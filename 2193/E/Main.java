import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
    int n = a.length;

    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());

    int[] sorted = Arrays.stream(a).sorted().distinct().toArray();
    int index = sorted.length - 1;

    int[] result = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);
    for (int i = 0; i < result.length; ++i) {
      if (set.contains(i + 1)) {
        result[i] = 1;
      }

      if (result[i] != Integer.MAX_VALUE) {
        while (index != -1 && sorted[index] * (i + 1L) > n) {
          --index;
        }

        for (int j = 0; j <= index; ++j) {
          result[(i + 1) * sorted[j] - 1] =
              Math.min(result[(i + 1) * sorted[j] - 1], result[i] + 1);
        }
      }
    }

    return Arrays.stream(result)
        .map(x -> (x == Integer.MAX_VALUE) ? -1 : x)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}