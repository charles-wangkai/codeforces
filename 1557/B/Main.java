import java.util.Arrays;
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
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int k) {
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, sorted.length).boxed().collect(Collectors.toMap(i -> sorted[i], i -> i));

    return IntStream.range(0, a.length - 1)
                .filter(i -> valueToIndex.get(a[i]) + 1 != valueToIndex.get(a[i + 1]))
                .count()
            + 1
        <= k;
  }
}
