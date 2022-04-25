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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int m) {
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

    return IntStream.range(0, sorted.length)
                .map(i -> Math.max(sorted[i], sorted[Math.floorMod(i - 1, sorted.length)]))
                .asLongStream()
                .sum()
            + a.length
        <= m;
  }
}