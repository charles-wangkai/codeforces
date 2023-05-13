import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int result = (p.length + 1) / 2;
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));
    int leftIndex = Integer.MAX_VALUE;
    int rightIndex = Integer.MIN_VALUE;
    int lowerValue = (p.length + 1) / 2;
    int upperValue = p.length / 2 + 1;
    while (lowerValue != 0
        && valueToIndex.get(lowerValue) < leftIndex
        && valueToIndex.get(upperValue) > rightIndex
        && valueToIndex.get(lowerValue) <= valueToIndex.get(upperValue)) {
      leftIndex = valueToIndex.get(lowerValue);
      rightIndex = valueToIndex.get(upperValue);

      --lowerValue;
      ++upperValue;
      --result;
    }

    return result;
  }
}
