import java.util.Scanner;
import java.util.stream.Collectors;
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
      int q = sc.nextInt();
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] r) {
    int[] nextDiffIndices = new int[a.length];
    nextDiffIndices[nextDiffIndices.length - 1] = a.length;
    for (int i = nextDiffIndices.length - 2; i >= 0; --i) {
      nextDiffIndices[i] = (a[i] == a[i + 1]) ? nextDiffIndices[i + 1] : (i + 1);
    }

    return IntStream.range(0, l.length)
        .mapToObj(
            i ->
                (nextDiffIndices[l[i] - 1] <= r[i] - 1)
                    ? String.format("%d %d", l[i], nextDiffIndices[l[i] - 1] + 1)
                    : "-1 -1")
        .collect(Collectors.joining("\n"));
  }
}