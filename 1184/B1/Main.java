import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int s = sc.nextInt();
    int b = sc.nextInt();
    int[] a = new int[s];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] d = new int[b];
    int[] g = new int[b];
    for (int i = 0; i < b; ++i) {
      d[i] = sc.nextInt();
      g[i] = sc.nextInt();
    }

    System.out.println(solve(a, d, g));

    sc.close();
  }

  static String solve(int[] a, int[] d, int[] g) {
    int[] sortedSpaceshipIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] sortedBaseIndices =
        IntStream.range(0, d.length)
            .boxed()
            .sorted(Comparator.comparing(i -> d[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] result = new int[a.length];
    int baseCount = 0;
    int goldNum = 0;
    for (int spaceshipIndex : sortedSpaceshipIndices) {
      while (baseCount != sortedBaseIndices.length
          && d[sortedBaseIndices[baseCount]] <= a[spaceshipIndex]) {
        goldNum += g[sortedBaseIndices[baseCount]];
        ++baseCount;
      }

      result[spaceshipIndex] = goldNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}