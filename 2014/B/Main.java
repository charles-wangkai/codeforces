import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int k) {
    return ((long) n * k - k * (k - 1L) / 2) % 2 == 0;
  }
}