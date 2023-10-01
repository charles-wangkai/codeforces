import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, x));
    }

    sc.close();
  }

  static long solve(int a, int b, int[] x) {
    return b + Arrays.stream(x).map(xi -> Math.min(xi, a - 1)).asLongStream().sum();
  }
}
