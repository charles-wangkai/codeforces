import java.util.Arrays;
import java.util.Comparator;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int[] depths = new int[a.length];
    fill(depths, a, 0, a.length - 1, 0);

    return Arrays.stream(depths).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void fill(int[] depths, int[] a, int beginIndex, int endIndex, int depth) {
    if (beginIndex > endIndex) {
      return;
    }

    int rootIndex =
        IntStream.rangeClosed(beginIndex, endIndex)
            .boxed()
            .max(Comparator.comparing(i -> a[i]))
            .get();
    depths[rootIndex] = depth;

    fill(depths, a, beginIndex, rootIndex - 1, depth + 1);
    fill(depths, a, rootIndex + 1, endIndex, depth + 1);
  }
}
