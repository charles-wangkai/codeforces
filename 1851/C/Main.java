import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] c, int k) {
    int[] firstColorIndices = IntStream.range(0, c.length).filter(i -> c[i] == c[0]).toArray();
    int[] lastColorIndices =
        IntStream.range(0, c.length).filter(i -> c[i] == c[c.length - 1]).toArray();

    return firstColorIndices.length >= k
        && lastColorIndices.length >= k
        && (c[0] == c[c.length - 1]
            || firstColorIndices[k - 1] < lastColorIndices[lastColorIndices.length - k]);
  }
}
