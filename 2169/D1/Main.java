import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      long y = sc.nextLong();
      long k = sc.nextLong();

      System.out.println(solve(x, y, k));
    }

    sc.close();
  }

  static long solve(int x, long y, long k) {
    long result = -1;
    long lower = 1;
    long upper = 1_000_000_000_000L;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (computeFinalLength(x, y, middle) >= k) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static long computeFinalLength(int x, long y, long length) {
    for (int i = 0; i < x; ++i) {
      length -= length / y;
    }

    return length;
  }
}