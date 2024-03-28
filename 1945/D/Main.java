import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, m));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int m) {
    long result = Long.MAX_VALUE;
    long sum = 0;
    for (int i = m - 1; i >= 0; --i) {
      result = Math.min(result, sum + a[i]);
      sum += Math.min(a[i], b[i]);
    }

    result += IntStream.range(m, a.length).map(i -> Math.min(a[i], b[i])).asLongStream().sum();

    return result;
  }
}