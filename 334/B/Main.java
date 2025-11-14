import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] x = new int[8];
    int[] y = new int[8];
    for (int i = 0; i < 8; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y) ? "respectable" : "ugly");

    sc.close();
  }

  static boolean solve(int[] x, int[] y) {
    int[] sortedXs = Arrays.stream(x).distinct().sorted().toArray();
    int[] sortedYs = Arrays.stream(y).distinct().sorted().toArray();

    return sortedXs.length == 3
        && sortedYs.length == 3
        && IntStream.range(0, x.length)
            .mapToObj(i -> new Point(x[i], y[i]))
            .collect(Collectors.toSet())
            .equals(
                IntStream.range(0, 3)
                    .boxed()
                    .flatMap(
                        i ->
                            IntStream.range(0, 3)
                                .filter(j -> i != 1 || j != 1)
                                .mapToObj(j -> new Point(sortedXs[i], sortedYs[j])))
                    .collect(Collectors.toSet()));
  }
}

record Point(int x, int y) {}
