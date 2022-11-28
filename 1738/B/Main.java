import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] s = new int[k];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(n, s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int[] s) {
    return IntStream.range(0, s.length - 2).allMatch(i -> s[i + 1] - s[i] <= s[i + 2] - s[i + 1])
        && (s.length == 1 || (s[1] - s[0]) * (n - s.length + 1L) >= s[0]);
  }
}
