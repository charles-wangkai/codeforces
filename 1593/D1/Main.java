import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int[] diffs = Arrays.stream(a).map(x -> x - min).filter(x -> x != 0).toArray();

    return (diffs.length == 0) ? -1 : Arrays.stream(diffs).reduce(Main::gcd).getAsInt();
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
