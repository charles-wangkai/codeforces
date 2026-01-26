import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, s, x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int s, int x) {
    int rest = s - Arrays.stream(a).sum();

    return rest >= 0 && rest % x == 0;
  }
}