import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int m = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, s, m) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] l, int[] r, int s, int m) {
    return IntStream.rangeClosed(0, l.length)
        .anyMatch(i -> ((i == l.length) ? m : l[i]) - ((i == 0) ? 0 : r[i - 1]) >= s);
  }
}