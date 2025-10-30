import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String s) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    int[] counts = letterToCount.values().stream().mapToInt(Integer::intValue).sorted().toArray();

    return counts.length == 4
        || (counts.length == 3 && counts[counts.length - 1] != 1)
        || (counts.length == 2 && counts[0] != 1);
  }
}