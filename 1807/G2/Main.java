import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] c) {
    Arrays.sort(c);

    long sum = 0;
    for (int i = 0; i < c.length; ++i) {
      if (c[i] != 1 && c[i] > sum) {
        return false;
      }

      sum += c[i];
    }

    return true;
  }
}
