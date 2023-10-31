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
    for (int i = 1; i <= a.length; i *= 2) {
      if (IntStream.range(i, Math.min(a.length, i * 2) - 1).anyMatch(j -> a[j] > a[j + 1])) {
        return false;
      }
    }

    return true;
  }
}
