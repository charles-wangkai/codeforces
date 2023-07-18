import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] friendXs = new int[k];
      int[] friendYs = new int[k];
      for (int i = 0; i < k; ++i) {
        friendXs[i] = sc.nextInt();
        friendYs[i] = sc.nextInt();
      }

      System.out.println(solve(n, m, x, y, friendXs, friendYs) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int m, int x, int y, int[] friendXs, int[] friendYs) {
    return IntStream.range(0, friendXs.length)
        .allMatch(i -> (friendXs[i] + friendYs[i]) % 2 != (x + y) % 2);
  }
}
