import java.util.Arrays;
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
      int[] d = new int[n];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }

      System.out.println(solve(p, d));
    }

    sc.close();
  }

  static String solve(int[] p, int[] d) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    int[] result = new int[d.length];
    int operationNum = 0;
    boolean[] used = new boolean[p.length];
    for (int i = 0; i < result.length; ++i) {
      int index = d[i] - 1;
      while (!used[index]) {
        used[index] = true;
        ++operationNum;

        index = valueToIndex.get(index + 1);
      }

      result[i] = operationNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}