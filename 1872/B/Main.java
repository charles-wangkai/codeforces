import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] d = new int[n];
      int[] s = new int[n];
      for (int i = 0; i < n; ++i) {
        d[i] = sc.nextInt();
        s[i] = sc.nextInt();
      }

      System.out.println(solve(d, s));
    }

    sc.close();
  }

  static int solve(int[] d, int[] s) {
    return IntStream.range(0, d.length).map(i -> d[i] + (s[i] - 1) / 2).min().getAsInt();
  }
}
