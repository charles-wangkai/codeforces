import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(l, r, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int l, int r, int k) {
    return r >= 2
        && (k == r - l || k >= (r - l + 1) / 2 + ((l % 2 != 0 && (r - l + 1) % 2 != 0) ? 1 : 0));
  }
}