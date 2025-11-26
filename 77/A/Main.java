import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String[] HERO_NAMES = {
    "Anka", "Chapay", "Cleo", "Troll", "Dracul", "Snowy", "Hexadecimal"
  };
  static final Map<String, Integer> HERO_NAME_TO_INDEX =
      IntStream.range(0, HERO_NAMES.length)
          .boxed()
          .collect(Collectors.toMap(i -> HERO_NAMES[i], i -> i));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.nextLine();
    }
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    System.out.println(solve(s, a, b, c));

    sc.close();
  }

  static String solve(String[] s, int a, int b, int c) {
    Liking[] likings =
        Arrays.stream(s)
            .map(
                si -> {
                  String[] fields = si.split(" ");

                  return new Liking(
                      HERO_NAME_TO_INDEX.get(fields[0]), HERO_NAME_TO_INDEX.get(fields[2]));
                })
            .toArray(Liking[]::new);

    Outcome outcome = search(new int[] {a, b, c}, likings, new int[3], new int[7], 0);

    return "%d %d".formatted(outcome.difference(), outcome.totalLiking());
  }

  static Outcome search(
      int[] experiences, Liking[] likings, int[] teamSizes, int[] heroTeams, int index) {
    if (index == heroTeams.length) {
      if (Arrays.stream(teamSizes).anyMatch(teamSize -> teamSize == 0)) {
        return null;
      }

      int[] sorted =
          IntStream.range(0, teamSizes.length)
              .map(i -> experiences[i] / teamSizes[i])
              .sorted()
              .toArray();

      return new Outcome(
          sorted[sorted.length - 1] - sorted[0],
          (int)
              Arrays.stream(likings)
                  .filter(liking -> heroTeams[liking.from()] == heroTeams[liking.to()])
                  .count());
    }

    Outcome result = null;
    for (int i = 0; i < 3; ++i) {
      ++teamSizes[i];
      heroTeams[index] = i;

      result = merge(result, search(experiences, likings, teamSizes, heroTeams, index + 1));

      --teamSizes[i];
    }

    return result;
  }

  static Outcome merge(Outcome o1, Outcome o2) {
    return (o2 == null
            || (o1 != null
                && (o1.difference() < o2.difference()
                    || (o1.difference() == o2.difference()
                        && o1.totalLiking() >= o2.totalLiking()))))
        ? o1
        : o2;
  }
}

record Liking(int from, int to) {}

record Outcome(int difference, int totalLiking) {}
