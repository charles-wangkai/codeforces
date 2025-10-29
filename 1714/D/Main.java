import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      String t = sc.next();
      int n = sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(t, s));
    }

    sc.close();
  }

  static String solve(String t, String[] s) {
    int[] dp = new int[t.length() + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i < dp.length; ++i) {
      int length = -1;
      for (String si : s) {
        if (isEnd(t, i, si)) {
          length = Math.max(length, si.length());
        }
      }

      for (int j = 1; j <= length && j <= i; ++j) {
        if (dp[i - j] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - j] + 1);
        }
      }
    }

    if (dp[dp.length - 1] == Integer.MAX_VALUE) {
      return "-1";
    }

    List<String> steps = new ArrayList<>();
    int index = dp.length - 1;
    while (index != 0) {
      int length = -1;
      int w = -1;
      for (int i = 0; i < s.length; ++i) {
        if (isEnd(t, index, s[i])) {
          if (s[i].length() > length) {
            length = s[i].length();
            w = i + 1;
          }
        }
      }

      steps.add("%d %d".formatted(w, index - length + 1));

      int nextIndex = index;
      while (dp[nextIndex] != dp[index] - 1) {
        --nextIndex;
      }
      index = nextIndex;
    }

    return "%d\n%s".formatted(steps.size(), String.join("\n", steps));
  }

  static boolean isEnd(String t, int length, String str) {
    return length >= str.length()
        && IntStream.range(0, str.length())
            .allMatch(i -> str.charAt(str.length() - 1 - i) == t.charAt(length - 1 - i));
  }
}