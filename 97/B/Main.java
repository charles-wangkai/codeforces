// https://www.hankcs.com/program/algorithm/codeforces-97b-superset.html

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static String solve(int[] x, int[] y) {
    int[] sortedIndices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.comparing(i -> x[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    Set<Point> superset = new HashSet<>();
    search(superset, x, y, sortedIndices, 0, sortedIndices.length - 1);

    return "%d\n%s"
        .formatted(
            superset.size(),
            superset.stream()
                .map(point -> "%d %d".formatted(point.x(), point.y()))
                .collect(Collectors.joining("\n")));
  }

  static void search(
      Set<Point> superset, int[] x, int[] y, int[] sortedIndices, int beginIndex, int endIndex) {
    if (beginIndex <= endIndex) {
      int middleIndex = (beginIndex + endIndex) / 2;
      for (int i = beginIndex; i <= endIndex; ++i) {
        superset.add(new Point(x[sortedIndices[middleIndex]], y[sortedIndices[i]]));
      }

      search(superset, x, y, sortedIndices, beginIndex, middleIndex - 1);
      search(superset, x, y, sortedIndices, middleIndex + 1, endIndex);
    }
  }
}

record Point(int x, int y) {}
