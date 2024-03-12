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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] c = new int[m];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(b, c, k));
    }

    sc.close();
  }

  static int solve(int[] b, int[] c, int k) {
    return Arrays.stream(b)
        .map(bi -> (int) Arrays.stream(c).filter(ci -> bi + ci <= k).count())
        .sum();
  }
}