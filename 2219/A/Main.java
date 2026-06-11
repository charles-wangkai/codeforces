import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int p = sc.nextInt();
      int q = sc.nextInt();

      System.out.println(solve(p, q));
    }

    sc.close();
  }

  static String solve(int p, int q) {
    int total = p + 2 * q;

    for (int n = 1; 2 * n * n + 2 * n <= total; ++n) {
      if ((total - n) % (2 * n + 1) == 0) {
        int m = (total - n) / (2 * n + 1);
        if (p >= m - n) {
          return "%d %d".formatted(n, m);
        }
      }
    }

    return "-1";
  }
}