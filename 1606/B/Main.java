import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();
      long k = sc.nextLong();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static long solve(long n, long k) {
    long result = 0;
    long installed = 1;
    long rest = n - 1;
    while (installed < k) {
      long delta = Math.min(installed, rest);
      installed += delta;
      rest -= delta;

      ++result;
    }
    result += (rest + k - 1) / k;

    return result;
  }
}
