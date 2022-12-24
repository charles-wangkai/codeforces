import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] c = new int[m];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c) {
    Map<Integer, Stack<Integer>> colorToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (a[i] != b[i]) {
        colorToIndices.putIfAbsent(b[i], new Stack<>());
        colorToIndices.get(b[i]).push(i);
      }
    }

    int[] result = new int[c.length];
    for (int i = result.length - 1; i >= 0; --i) {
      int i_ = i;
      if (i == result.length - 1 && Arrays.stream(b).allMatch(bi -> bi != c[i_])) {
        return "NO";
      }

      if (colorToIndices.containsKey(c[i]) && !colorToIndices.get(c[i]).empty()) {
        result[i] = colorToIndices.get(c[i]).pop();
      } else {
        result[i] =
            (i == result.length - 1)
                ? IntStream.range(0, b.length).filter(j -> b[j] == c[i_]).findAny().getAsInt()
                : result[i + 1];
      }
    }

    return colorToIndices.values().stream().allMatch(Stack::empty)
        ? String.format(
            "YES\n%s",
            Arrays.stream(result)
                .map(i -> i + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")))
        : "NO";
  }
}
