import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

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

  static int solve(int[] a, int k) {
    long maxSum = 0;
    long sum = 0;
    for (int ai : a) {
      sum = Math.max(0, sum + ai);
      maxSum = Math.max(maxSum, sum);
    }

    int result = 0;
    int currentSum = (int) (maxSum % MODULUS);
    for (int i = 0; i < k; ++i) {
      result = addMod(result, currentSum);
      currentSum = addMod(currentSum, currentSum);
    }
    for (int ai : a) {
      result = addMod(result, ai);
    }

    return result;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}