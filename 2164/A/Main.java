import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int x = sc.nextInt();

      System.out.println(solve(a, x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int x) {
    return x >= Arrays.stream(a).min().getAsInt() && x <= Arrays.stream(a).max().getAsInt();
  }
}