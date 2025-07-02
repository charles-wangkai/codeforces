import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int j = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, j, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int j, int k) {
    return a[j - 1] == Arrays.stream(a).max().getAsInt() || k != 1;
  }
}