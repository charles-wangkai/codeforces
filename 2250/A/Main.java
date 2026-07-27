import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }

      System.out.println(solve(w) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] w) {
    return w.length % 2 == 0
        && IntStream.range(0, w.length / 2).map(i -> w[i * 2]).min().getAsInt()
                - IntStream.range(0, w.length / 2).map(i -> w[i * 2 + 1]).max().getAsInt()
            >= 2;
  }
}