import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] r = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      r[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(r, c, m, k));

    sc.close();
  }

  static int solve(int[] r, int[] c, int m, int k) {
    int[] minValues = new int[m];
    Arrays.fill(minValues, Integer.MAX_VALUE);

    for (int i = 0; i < r.length; ++i) {
      minValues[r[i] - 1] = Math.min(minValues[r[i] - 1], c[i]);
    }

    return Math.min(k, Arrays.stream(minValues).sum());
  }
}