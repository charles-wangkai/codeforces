import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k1 = sc.nextInt();
      int k2 = sc.nextInt();
      int w = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, k1, k2, w, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int k1, int k2, int w, int b) {
    return canPlace(k1, k2, w) && canPlace(n - k1, n - k2, b);
  }

  static boolean canPlace(int c1, int c2, int target) {
    int min = Math.min(c1, c2);

    return min + (c1 + c2 - min * 2) / 2 >= target;
  }
}
