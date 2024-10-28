import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int r = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(n, m, r, c));
    }

    sc.close();
  }

  static long solve(int n, int m, int r, int c) {
    return (m - c) + (n - r) * (m * 2L - 1);
  }
}