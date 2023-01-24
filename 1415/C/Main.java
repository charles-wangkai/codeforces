import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int p = sc.nextInt();
      int k = sc.nextInt();
      String a = sc.next();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(a, p, k, x, y));
    }

    sc.close();
  }

  static int solve(String a, int p, int k, int x, int y) {
    int result = Integer.MAX_VALUE;
    int[] counts = new int[k];
    for (int i = a.length() - 1; i >= p - 1; --i) {
      if (a.charAt(i) == '0') {
        ++counts[i % k];
      }

      result = Math.min(result, x * counts[i % k] + y * (i - p + 1));
    }

    return result;
  }
}
