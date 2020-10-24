import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    for (int k = 0; k * 7 <= n; ++k) {
      for (int j = 0; k * 7 + j * 5 <= n; ++j) {
        if ((n - k * 7 - j * 5) % 3 == 0) {
          return String.format("%d %d %d", (n - k * 7 - j * 5) / 3, j, k);
        }
      }
    }

    return "-1";
  }
}
