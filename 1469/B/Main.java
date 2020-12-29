import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] r = new int[n];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(r, b));
    }

    sc.close();
  }

  static int solve(int[] r, int[] b) {
    return computeMaxPrefixSum(r) + computeMaxPrefixSum(b);
  }

  static int computeMaxPrefixSum(int[] a) {
    int result = 0;
    int sum = 0;
    for (int ai : a) {
      sum += ai;
      result = Math.max(result, sum);
    }

    return result;
  }
}
