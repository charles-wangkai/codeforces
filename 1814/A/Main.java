import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();
      long k = sc.nextLong();

      System.out.println(solve(n, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long n, long k) {
    return n % 2 == 0 || k % 2 == 1;
  }
}
