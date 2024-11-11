import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(long[] a, long k) {
    long sumA = Arrays.stream(a).sum();
    long maxA = Arrays.stream(a).max().getAsLong();

    return IntStream.rangeClosed(1, a.length)
        .filter(
            i -> {
              long total = (sumA + k) / i * i;

              return total >= sumA && total <= sumA + k && total / i >= maxA;
            })
        .max()
        .getAsInt();
  }
}