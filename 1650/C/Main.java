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
      int m = sc.nextInt();
      int[] x = new int[m];
      int[] w = new int[m];
      for (int i = 0; i < m; ++i) {
        x[i] = sc.nextInt();
        w[i] = sc.nextInt();
      }

      System.out.println(solve(n, x, w));
    }

    sc.close();
  }

  static String solve(int n, int[] x, int[] w) {
    int[] indices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.comparing(i -> w[i]))
            .limit(2 * n)
            .sorted(Comparator.comparing(i -> x[i]))
            .mapToInt(i -> i)
            .toArray();

    return String.format(
        "%d\n%s",
        Arrays.stream(indices).map(i -> w[i]).sum(),
        IntStream.range(0, indices.length / 2)
            .mapToObj(
                i -> String.format("%d %d", indices[i] + 1, indices[indices.length - 1 - i] + 1))
            .collect(Collectors.joining("\n")));
  }
}