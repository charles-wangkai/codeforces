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

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    long result = Long.MIN_VALUE;
    for (int j = a.length - 1; j >= 0; --j) {
      for (int i = j - 1; i >= 0 && (i + 1L) * (j + 1) >= result; --i) {
        result = Math.max(result, (i + 1L) * (j + 1) - (long) k * (a[i] | a[j]));
      }
    }

    return result;
  }
}