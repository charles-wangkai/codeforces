import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String homeName = sc.next();
    String awayName = sc.next();
    int n = sc.nextInt();
    int[] t = new int[n];
    String[] teams = new String[n];
    int[] playerNumbers = new int[n];
    String[] cards = new String[n];
    for (int i = 0; i < n; ++i) {
      t[i] = sc.nextInt();
      teams[i] = sc.next();
      playerNumbers[i] = sc.nextInt();
      cards[i] = sc.next();
    }

    System.out.println(solve(homeName, awayName, t, teams, playerNumbers, cards));

    sc.close();
  }

  static String solve(
      String homeName,
      String awayName,
      int[] t,
      String[] teams,
      int[] playerNumbers,
      String[] cards) {
    List<String> result = new ArrayList<>();
    Set<Player> yellowSeen = new HashSet<>();
    Set<Player> redSeen = new HashSet<>();
    for (int i = 0; i < t.length; ++i) {
      Player player = new Player(teams[i], playerNumbers[i]);
      if (!redSeen.contains(player) && (cards[i].equals("r") || yellowSeen.contains(player))) {
        result.add(
            "%s %d %d"
                .formatted(teams[i].equals("h") ? homeName : awayName, playerNumbers[i], t[i]));
        redSeen.add(player);
      } else if (cards[i].equals("y")) {
        yellowSeen.add(player);
      }
    }

    return String.join("\n", result);
  }
}

record Player(String team, int playerNumber) {}
