import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    long sum =
        IntStream.range(0, a.length).map(i -> ((i % 2 == 0) ? 1 : -1) * a[i]).asLongStream().sum();

    long result = sum + (a.length - 1) / 2 * 2;
    long evenMaxTerm = Long.MIN_VALUE;
    long oddMaxTerm = Long.MIN_VALUE;
    for (int i = 0; i < a.length; ++i) {
      if (i % 2 == 0) {
        if (oddMaxTerm != Long.MIN_VALUE) {
          result = Math.max(result, sum + oddMaxTerm + (-2 * a[i] + i));
        }

        evenMaxTerm = Math.max(evenMaxTerm, -2 * a[i] - i);
      } else {
        if (evenMaxTerm != Long.MIN_VALUE) {
          result = Math.max(result, sum + evenMaxTerm + (2 * a[i] + i));
        }

        oddMaxTerm = Math.max(oddMaxTerm, 2 * a[i] - i);
      }
    }

    return result;
  }
}