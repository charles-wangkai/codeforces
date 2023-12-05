import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int d = sc.nextInt();
      int[] s = new int[m];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(n, s, d));
    }

    sc.close();
  }

  static String solve(int n, int[] s, int d) {
    int[] deltas =
        IntStream.range(0, s.length)
            .map(
                i ->
                    computeDelta(
                        d, (i == 0) ? 1 : s[i - 1], s[i], (i == s.length - 1) ? (n + 1) : s[i + 1]))
            .toArray();
    int minDelta = Arrays.stream(deltas).min().getAsInt();
    int removedIndex =
        IntStream.range(0, deltas.length).filter(i -> deltas[i] == minDelta).findAny().getAsInt();

    return String.format(
        "%d %d",
        computeCookieNum(
            n,
            d,
            IntStream.range(0, s.length).filter(i -> i != removedIndex).map(i -> s[i]).toArray()),
        Arrays.stream(deltas).filter(delta -> delta == minDelta).count());
  }

  static int computeDelta(int d, int pos1, int pos2, int pos3) {
    return computeMiddlePointNum(d, pos1, pos3)
        - (computeMiddlePointNum(d, pos1, pos2) + computeMiddlePointNum(d, pos2, pos3) + 1);
  }

  static int computeMiddlePointNum(int d, int begin, int end) {
    return Math.floorDiv(end - begin - 1, d);
  }

  static int computeCookieNum(int n, int d, int[] sellerPoses) {
    return sellerPoses.length
        + 1
        + IntStream.rangeClosed(0, sellerPoses.length)
            .map(
                i ->
                    computeMiddlePointNum(
                        d,
                        (i == 0) ? 1 : sellerPoses[i - 1],
                        (i == sellerPoses.length) ? (n + 1) : sellerPoses[i]))
            .sum();
  }
}