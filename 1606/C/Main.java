import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    long result = 0;
    int rest = k + 1;
    for (int i = 0; i < a.length; ++i) {
      int noteNum =
          Math.min((i == a.length - 1) ? Integer.MAX_VALUE : pow10(a[i + 1] - a[i]) - 1, rest);
      result += (long) pow10(a[i]) * noteNum;

      rest -= noteNum;
    }

    return result;
  }

  static int pow10(int exponent) {
    return IntStream.range(0, exponent).reduce(1, (x, y) -> x * 10);
  }
}