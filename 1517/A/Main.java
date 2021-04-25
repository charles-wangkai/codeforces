import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(long n) {
    return (n % 2050 == 0) ? String.valueOf(n / 2050).chars().map(ch -> ch - '0').sum() : -1;
  }
}
