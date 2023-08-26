import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(long n) {
    int flavourNum = -1;
    int lower = 1;
    int upper = Integer.MAX_VALUE;
    while (lower <= upper) {
      int middle = lower + (upper - lower) / 2;
      if (middle * (middle - 1L) / 2 <= n) {
        flavourNum = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return flavourNum + (n - flavourNum * (flavourNum - 1L) / 2);
  }
}
