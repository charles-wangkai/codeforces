import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }
    int[] g = new int[m];
    for (int i = 0; i < g.length; ++i) {
      g[i] = sc.nextInt();
    }

    System.out.println(solve(b, g));

    sc.close();
  }

  static long solve(int[] b, int[] g) {
    Arrays.sort(b);
    Arrays.sort(g);

    if (g[0] < b[b.length - 1]) {
      return -1;
    }

    return Arrays.stream(b).asLongStream().sum() * g.length
        + ((g[0] == b[b.length - 1])
            ? Arrays.stream(g).map(gi -> gi - b[b.length - 1]).asLongStream().sum()
            : ((g[0] - b[b.length - 2])
                + IntStream.range(1, g.length)
                    .map(i -> g[i] - b[b.length - 1])
                    .asLongStream()
                    .sum()));
  }
}