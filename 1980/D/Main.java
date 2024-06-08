import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int n = a.length;

    boolean[] leftSorted = new boolean[n];
    leftSorted[0] = true;
    leftSorted[1] = true;
    for (int i = 2; i < leftSorted.length; ++i) {
      leftSorted[i] = leftSorted[i - 1] && gcd(a[i], a[i - 1]) >= gcd(a[i - 1], a[i - 2]);
    }

    boolean[] rightSorted = new boolean[n];
    rightSorted[rightSorted.length - 1] = true;
    rightSorted[rightSorted.length - 2] = true;
    for (int i = rightSorted.length - 3; i >= 0; --i) {
      rightSorted[i] = rightSorted[i + 1] && gcd(a[i], a[i + 1]) <= gcd(a[i + 1], a[i + 2]);
    }

    return IntStream.range(0, n)
        .anyMatch(
            i ->
                (i == 0 || leftSorted[i - 1])
                    && (i == n - 1 || rightSorted[i + 1])
                    && (i <= 1 || i == n - 1 || gcd(a[i - 1], a[i + 1]) >= gcd(a[i - 1], a[i - 2]))
                    && (i >= n - 2
                        || i == 0
                        || gcd(a[i - 1], a[i + 1]) <= gcd(a[i + 1], a[i + 2])));
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}