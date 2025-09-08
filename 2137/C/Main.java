import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(long a, long b) {
    if (b % 2 == 1) {
      return (a % 2 == 1) ? (a * b + 1) : -1;
    }
    if (b == 2) {
      return (a % 2 == 0) ? (a + b) : -1;
    }

    long maxSum = a * b / 2 + 2;

    return (maxSum % 2 == 0) ? maxSum : -1;
  }
}