import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(a, b, c, m) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int c, int m) {
    int[] sorted = IntStream.of(a, b, c).sorted().toArray();
    int minPairNum = Math.max(0, sorted[2] - (sorted[0] + sorted[1] + 1));

    int maxPairNum = Math.max(0, a - 1) + Math.max(0, b - 1) + Math.max(0, c - 1);

    return m >= minPairNum && m <= maxPairNum;
  }
}
