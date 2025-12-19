import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    long[] result = new long[a.length + 1];
    Arrays.fill(result, -1);

    Deque<Integer> stack = new ArrayDeque<>();
    long sum = 0;
    for (int mex = 0; mex < result.length; ++mex) {
      result[mex] = sum + valueToCount.getOrDefault(mex, 0);

      if (valueToCount.containsKey(mex)) {
        for (int i = 0; i < valueToCount.get(mex) - 1; ++i) {
          stack.push(mex);
        }
      } else if (stack.isEmpty()) {
        break;
      } else {
        sum += mex - stack.pop();
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}