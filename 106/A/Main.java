import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static Map<Character, Integer> RANK_TO_VALUE =
      Map.ofEntries(
          entry('6', 6),
          entry('7', 7),
          entry('8', 8),
          entry('9', 9),
          entry('T', 10),
          entry('J', 11),
          entry('Q', 12),
          entry('K', 13),
          entry('A', 14));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char trump = sc.next().charAt(0);
    String card1 = sc.next();
    String card2 = sc.next();

    System.out.println(solve(trump, card1, card2) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(char trump, String card1, String card2) {
    return (card1.charAt(1) == card2.charAt(1)
            && RANK_TO_VALUE.get(card1.charAt(0)) > RANK_TO_VALUE.get(card2.charAt(0)))
        || (card1.charAt(1) == trump && card2.charAt(1) != trump);
  }
}