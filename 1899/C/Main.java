import java.util.Scanner;

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

  static int solve(int[] a) {
    int result = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < a.length; ++i) {
      sum += a[i];
      result = Math.max(result, sum);

      if (sum < 0 || (i != a.length - 1 && Math.floorMod(a[i + 1], 2) == Math.floorMod(a[i], 2))) {
        sum = 0;
      }
    }

    return result;
  }
}
