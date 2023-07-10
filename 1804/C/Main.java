import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int p = sc.nextInt();

      System.out.println(solve(n, x, p) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int n, int x, int p) {
    return IntStream.rangeClosed(1, Math.min(2 * n, p))
        .anyMatch(f -> (x + f * (f + 1L) / 2) % n == 0);
  }
}
