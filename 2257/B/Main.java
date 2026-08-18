import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    return (computeTurnNum(a) >= computeTurnNum(b)) ? 1 : 2;
  }

  static long computeTurnNum(int[] heights) {
    return IntStream.range(0, heights.length)
        .map(i -> heights[i] - ((i == heights.length - 1) ? 0 : (heights[i + 1] - 1)))
        .asLongStream()
        .sum();
  }
}