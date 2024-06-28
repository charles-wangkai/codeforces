import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x, a, b));
    }

    sc.close();
  }

  static long solve(int[] x, int a, int b) {
    long result = Arrays.stream(x).asLongStream().sum() * b;
    long cost = result;
    for (int i = 0; i < x.length; ++i) {
      cost += (x[i] - ((i == 0) ? 0 : x[i - 1])) * (a - b * (x.length - 1L - i));
      result = Math.min(result, cost);
    }

    return result;
  }
}