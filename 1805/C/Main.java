import java.util.NavigableSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] k = new int[n];
      for (int i = 0; i < k.length; ++i) {
        k[i] = sc.nextInt();
      }
      int[] a = new int[m];
      int[] b = new int[m];
      int[] c = new int[m];
      for (int i = 0; i < m; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(k, a, b, c));
    }

    sc.close();
  }

  static String solve(int[] k, int[] a, int[] b, int[] c) {
    NavigableSet<Integer> kSet = new TreeSet<>();
    for (int ki : k) {
      kSet.add(ki);
    }

    return IntStream.range(0, a.length)
        .mapToObj(
            i ->
                Stream.of(kSet.floor(b[i]), kSet.ceiling(b[i]))
                    .filter(Objects::nonNull)
                    .filter(
                        kCandidate ->
                            (long) (kCandidate - b[i]) * (kCandidate - b[i]) - 4L * a[i] * c[i] < 0)
                    .map(kCandidate -> String.format("YES\n%d", kCandidate))
                    .findAny()
                    .orElse("NO"))
        .collect(Collectors.joining("\n"));
  }
}
