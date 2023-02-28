import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int d = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(p, a, d));
    }

    sc.close();
  }

  static int solve(int[] p, int[] a, int d) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    return IntStream.range(0, a.length - 1)
        .map(
            i -> {
              int index1 = valueToIndex.get(a[i]);
              int index2 = valueToIndex.get(a[i + 1]);
              if (index1 > index2 || index1 + d < index2) {
                return 0;
              }

              return Math.min(
                  index2 - index1,
                  (d >= p.length - 1) ? Integer.MAX_VALUE : (d + 1 - (index2 - index1)));
            })
        .min()
        .getAsInt();
  }
}
