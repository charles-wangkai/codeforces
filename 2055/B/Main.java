import java.util.Scanner;
import java.util.stream.IntStream;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    int[] diffs = IntStream.range(0, a.length).map(i -> b[i] - a[i]).toArray();
    int[] positiveIndices = IntStream.range(0, diffs.length).filter(i -> diffs[i] > 0).toArray();

    return positiveIndices.length == 0
        || (positiveIndices.length == 1
            && IntStream.range(0, diffs.length)
                .allMatch(i -> i == positiveIndices[0] || -diffs[i] >= diffs[positiveIndices[0]]));
  }
}