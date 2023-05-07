import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] m = new int[n];
      String[] s = new String[n];
      for (int i = 0; i < n; ++i) {
        m[i] = sc.nextInt();
        s[i] = sc.next();
      }

      System.out.println(solve(m, s));
    }

    sc.close();
  }

  static int solve(int[] m, String[] s) {
    Map<String, Integer> skillsToTime = new HashMap<>();
    for (int i = 0; i < m.length; ++i) {
      skillsToTime.put(s[i], Math.min(skillsToTime.getOrDefault(s[i], Integer.MAX_VALUE), m[i]));
    }

    int result =
        Math.min(
            skillsToTime.getOrDefault("11", Integer.MAX_VALUE),
            (skillsToTime.containsKey("01") && skillsToTime.containsKey("10"))
                ? (skillsToTime.get("01") + skillsToTime.get("10"))
                : Integer.MAX_VALUE);

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }
}
