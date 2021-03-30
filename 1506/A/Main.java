import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      long x = sc.nextLong();

      System.out.println(solve(n, m, x));
    }

    sc.close();
  }

  static long solve(int n, int m, long x) {
    return (x - 1) % n * m + (x + n - 1) / n;
  }
}
