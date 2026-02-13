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
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(p, a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] p, int[] a) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    return IntStream.range(0, a.length - 1)
        .allMatch(i -> valueToIndex.get(a[i]) <= valueToIndex.get(a[i + 1]));
  }
}