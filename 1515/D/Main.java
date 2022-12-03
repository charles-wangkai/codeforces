import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
    for (int leftColor : leftColorToCount.keySet()) {
      leftColorToCount.put(
          leftColor,
          leftColorToCount.get(leftColor)
              - Math.min(
                  leftColorToCount.get(leftColor), rightColorToCount.getOrDefault(leftColor, 0)));
    }

    return leftColorToCount.values().stream().mapToInt(x -> x).sum()
        - Math.min(
            (l - r) / 2, leftColorToCount.values().stream().mapToInt(count -> count / 2).sum());
  }

  static Map<Integer, Integer> buildColorToCount(int[] c, int beginIndex, int endIndex) {
    Map<Integer, Integer> colorToCount = new HashMap<>();
    for (int i = beginIndex; i <= endIndex; ++i) {
      colorToCount.put(c[i], colorToCount.getOrDefault(c[i], 0) + 1);
    }

    return colorToCount;
  }
}
