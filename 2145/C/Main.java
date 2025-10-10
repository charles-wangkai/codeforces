import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int targetDiff =
        (int) s.chars().filter(c -> c == 'a').count()
            - (int) s.chars().filter(c -> c == 'b').count();

    int result = Integer.MAX_VALUE;
    Map<Integer, Integer> diffToLength = new HashMap<>();
    diffToLength.put(0, 0);
    int diff = 0;
    for (int i = 0; i < s.length(); ++i) {
      diff += (s.charAt(i) == 'a') ? 1 : -1;
      diffToLength.put(diff, i + 1);

      if (diffToLength.containsKey(diff - targetDiff)) {
        result = Math.min(result, i + 1 - diffToLength.get(diff - targetDiff));
      }
    }

    return (result == s.length()) ? -1 : result;
  }
}