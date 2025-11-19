import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] names = new String[n];
    for (int i = 0; i < names.length; ++i) {
      names[i] = sc.next();
    }
    sc.nextLine();
    String[] matches = new String[n * (n - 1) / 2];
    for (int i = 0; i < matches.length; ++i) {
      matches[i] = sc.nextLine();
    }

    System.out.println(solve(names, matches));

    sc.close();
  }

  static String solve(String[] names, String[] matches) {
    Map<String, Team> nameToTeam =
        Arrays.stream(names).collect(Collectors.toMap(name -> name, Team::new));

    for (String match : matches) {
      String[] fields = match.split("[- :]");
      String name1 = fields[0];
      String name2 = fields[1];
      int goal1 = Integer.parseInt(fields[2]);
      int goal2 = Integer.parseInt(fields[3]);

      if (goal1 < goal2) {
        nameToTeam.get(name2).point += 3;
      } else if (goal1 > goal2) {
        nameToTeam.get(name1).point += 3;
      } else {
        ++nameToTeam.get(name1).point;
        ++nameToTeam.get(name2).point;
      }

      nameToTeam.get(name1).scored += goal1;
      nameToTeam.get(name1).missed += goal2;

      nameToTeam.get(name2).scored += goal2;
      nameToTeam.get(name2).missed += goal1;
    }

    return nameToTeam.values().stream()
        .sorted(
            Comparator.<Team, Integer>comparing(team -> team.point)
                .reversed()
                .thenComparing(
                    Comparator.<Team, Integer>comparing(team -> team.scored - team.missed)
                        .reversed())
                .thenComparing(Comparator.<Team, Integer>comparing(team -> team.scored).reversed()))
        .limit(names.length / 2)
        .map(team -> team.name)
        .sorted()
        .collect(Collectors.joining("\n"));
  }
}

class Team {
  String name;
  int point;
  int scored;
  int missed;

  Team(String name) {
    this.name = name;
  }
}
