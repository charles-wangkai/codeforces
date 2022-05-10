import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String[] s) {
    int m = s[0].length();

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < s.length; ++i) {
      for (int j = i + 1; j < s.length; ++j) {
        int i_ = i;
        int j_ = j;
        result =
            Math.min(
                result,
                IntStream.range(0, m).map(k -> Math.abs(s[i_].charAt(k) - s[j_].charAt(k))).sum());
      }
    }

    return result;
  }
}