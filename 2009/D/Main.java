import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static long solve(int[] x, int[] y) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] xs = new Set[2];
    for (int i = 0; i < xs.length; ++i) {
      xs[i] = new HashSet<>();
    }
    for (int i = 0; i < x.length; ++i) {
      xs[y[i]].add(x[i]);
    }

    return IntStream.range(0, x.length)
        .map(
            i ->
                (xs[1 - y[i]].contains(x[i]) ? (xs[y[i]].size() - 1) : 0)
                    + ((xs[1 - y[i]].contains(x[i] - 1) && xs[1 - y[i]].contains(x[i] + 1))
                        ? 1
                        : 0))
        .asLongStream()
        .sum();
  }
}