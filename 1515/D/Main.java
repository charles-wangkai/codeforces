import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c, l, r));
    }

    sc.close();
  }

  static int solve(int[] c, int l, int r) {
    if (l < r) {
      return solve(IntStream.range(0, c.length).map(i -> c[c.length - 1 - i]).toArray(), r, l);
    }

    Map<Integer, Integer> leftColorToCount = buildColorToCount(c, 0, l - 1);
    Map<Integer, Integer> rightColorToCount = buildColorToCount(c, l, c.length - 1);
    int[] restCounts =
        leftColorToCount.keySet().stream()
            .mapToInt(
                leftColor ->
                    leftColorToCount.get(leftColor)
                        - Math.min(
                            leftColorToCount.get(leftColor),
                            rightColorToCount.getOrDefault(leftColor, 0)))
            .toArray();

    return Arrays.stream(restCounts).sum()
        - Math.min((l - r) / 2, Arrays.stream(restCounts).map(restCount -> restCount / 2).sum());
  }

  static Map<Integer, Integer> buildColorToCount(int[] c, int beginIndex, int endIndex) {
    return IntStream.rangeClosed(beginIndex, endIndex)
        .map(i -> c[i])
        .boxed()
        .collect(
            Collectors.toMap(Function.identity(), color -> 1, (count1, count2) -> count1 + count2));
  }
}
