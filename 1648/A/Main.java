import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] c = new int[n][m];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        c[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(c));

    sc.close();
  }

  static long solve(int[][] c) {
    int n = c.length;
    int m = c[0].length;

    return computeDistanceSum(
            IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.range(0, m).mapToObj(j -> new Element(i, c[i][j])))
                .toArray(Element[]::new))
        + computeDistanceSum(
            IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.range(0, m).mapToObj(j -> new Element(j, c[i][j])))
                .toArray(Element[]::new));
  }

  static long computeDistanceSum(Element[] elements) {
    Arrays.sort(elements, Comparator.comparing(Element::pos));

    long result = 0;
    Map<Integer, Long> colorToSum = new HashMap<>();
    Map<Integer, Integer> colorToCount = new HashMap<>();
    for (Element element : elements) {
      long sum = colorToSum.getOrDefault(element.color(), 0L);
      int count = colorToCount.getOrDefault(element.color(), 0);

      result += (long) element.pos() * count - sum;

      colorToSum.put(element.color(), sum + element.pos());
      colorToCount.put(element.color(), count + 1);
    }

    return result;
  }
}

record Element(int pos, int color) {}
