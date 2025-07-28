import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    StringBuilder result = new StringBuilder();
    boolean leftSmaller = true;
    for (int i = 0, j = p.length - 1; i <= j; ++i, --j) {
      if (i == j) {
        result.append('L');
      } else if ((p[i] < p[j]) == leftSmaller) {
        result.append("LR");
      } else {
        result.append("RL");
      }

      leftSmaller ^= true;
    }

    return result.toString();
  }
}