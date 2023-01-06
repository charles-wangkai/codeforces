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
      int k = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p, k));
    }

    sc.close();
  }

  static int solve(int[] p, int k) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    int sortedCount = 0;
    int lastIndex = -1;
    for (int i = 1; i <= p.length; ++i) {
      int index = valueToIndex.get(i);
      if (index < lastIndex) {
        break;
      }

      ++sortedCount;
      lastIndex = index;
    }

    return (p.length - sortedCount + k - 1) / k;
  }
}
