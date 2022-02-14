import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      long y = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static String solve(int[] a, int x, long y) {
    return ((Arrays.stream(a).asLongStream().sum() + x) % 2 == y % 2) ? "Alice" : "Bob";
  }
}