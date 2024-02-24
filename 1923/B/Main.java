import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] x, int k) {
    int n = a.length;

    int[] sortedIndices =
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.comparing(i -> Math.abs(x[i])))
            .mapToInt(Integer::intValue)
            .toArray();

    int distance = 0;
    int pos = 0;
    while (pos != sortedIndices.length) {
      if (Math.abs(x[sortedIndices[pos]]) == distance) {
        return false;
      }

      int rest = k;
      while (rest != 0 && pos != sortedIndices.length) {
        int delta = Math.min(rest, a[sortedIndices[pos]]);
        rest -= delta;
        a[sortedIndices[pos]] -= delta;
        if (a[sortedIndices[pos]] == 0) {
          ++pos;
        }
      }

      ++distance;
    }

    return true;
  }
}