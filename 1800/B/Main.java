import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    int result = 0;
    for (char c = 'a'; c <= 'z'; ++c) {
      int count1 = letterToCount.getOrDefault(c, 0);
      int count2 = letterToCount.getOrDefault(Character.toUpperCase(c), 0);

      result += Math.min(count1, count2);

      int extra = Math.min(k, Math.abs(count1 - count2) / 2);
      result += extra;
      k -= extra;
    }

    return result;
  }
}
