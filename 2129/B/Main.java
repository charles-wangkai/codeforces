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
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    int result = 0;
    boolean[] used = new boolean[p.length];
    for (int value = 1; value <= p.length; ++value) {
      int index = valueToIndex.get(value);
      used[index] = true;
      result +=
          Math.min(
              IntStream.range(0, index).filter(i -> !used[i]).count(),
              IntStream.range(index + 1, p.length).filter(i -> !used[i]).count());
    }

    return result;
  }
}