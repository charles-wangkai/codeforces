import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p, k));
    }

    sc.close();
  }

  static long solve(int[] p, int k) {
    long result = 0;
    long sum = Arrays.stream(p).asLongStream().sum();
    for (int i = p.length - 1; i >= 1; --i) {
      sum -= p[i];
      long delta = Math.max(0, (p[i] * 100L + k - 1) / k - sum);
      result += delta;
      sum += delta;
    }

    return result;
  }
}
