import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] s = new int[n];
      int[] e = new int[n];
      for (int i = 0; i < n; ++i) {
        s[i] = sc.nextInt();
        e[i] = sc.nextInt();
      }

      System.out.println(solve(s, e));
    }

    sc.close();
  }

  static int solve(int[] s, int[] e) {
    return IntStream.range(1, s.length).anyMatch(i -> s[i] >= s[0] && e[i] >= e[0]) ? -1 : s[0];
  }
}
