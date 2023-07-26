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
      int H = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h, m, k, H));
    }

    sc.close();
  }

  static int solve(int[] h, int m, int k, int H) {
    return (int)
        Arrays.stream(h)
            .filter(x -> x != H && (x - H) % k == 0 && Math.abs(x - H) <= (m - 1) * k)
            .count();
  }
}
