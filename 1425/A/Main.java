import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      long N = sc.nextLong();

      System.out.println(solve(N));
    }

    sc.close();
  }

  static long solve(long N) {
    long[] coins = new long[2];
    int index = 0;
    long rest = N;
    while (rest != 0) {
      if (rest == 4 || rest % 4 == 2) {
        coins[index] += rest / 2;
        rest /= 2;
      } else {
        ++coins[index];
        --rest;
      }

      index = 1 - index;
    }

    return coins[0];
  }
}