import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, a, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int[] a, int k) {
    int maxColorNum = Arrays.stream(a).max().getAsInt();

    return maxColorNum <= n / k
        || (maxColorNum == n / k + 1
            && Arrays.stream(a).filter(x -> x == maxColorNum).count() <= n % k);
  }
}
