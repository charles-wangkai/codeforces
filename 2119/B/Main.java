import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int px = sc.nextInt();
      int py = sc.nextInt();
      int qx = sc.nextInt();
      int qy = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, px, py, qx, qy) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a, int px, int py, int qx, int qy) {
    Arrays.sort(a);

    long distanceSquare = square(px - qx) + square(py - qy);

    return distanceSquare <= square(Arrays.stream(a).sum())
        && distanceSquare
            >= square(
                Math.max(
                    0, a[a.length - 1] - IntStream.range(0, a.length - 1).map(i -> a[i]).sum()));
  }

  static long square(int x) {
    return (long) x * x;
  }
}