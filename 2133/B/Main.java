import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] g = new int[n];
      for (int i = 0; i < g.length; ++i) {
        g[i] = sc.nextInt();
      }

      System.out.println(solve(g));
    }

    sc.close();
  }

  static long solve(int[] g) {
    Arrays.sort(g);

    long result = 0;
    for (int i = g.length - 1; i >= 0; i -= 2) {
      result += g[i];
    }

    return result;
  }
}