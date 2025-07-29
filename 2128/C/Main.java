import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] b) {
    int min = Integer.MAX_VALUE;
    for (int bi : b) {
      if (bi / 2 + 1 > min) {
        return false;
      }

      min = Math.min(min, bi);
    }

    return true;
  }
}