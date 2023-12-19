import java.util.Scanner;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int k) {
    int result = -1;
    int sumA = 0;
    int maxB = -1;
    for (int i = 0; i < a.length && i < k; ++i) {
      sumA += a[i];
      maxB = Math.max(maxB, b[i]);

      result = Math.max(result, sumA + (k - i - 1) * maxB);
    }

    return result;
  }
}