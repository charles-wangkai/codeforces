import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] d = new int[n];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, d));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] d) {
    int n = a.length;

    Map<Integer, Integer> bValueToIndex =
        IntStream.range(0, b.length).boxed().collect(Collectors.toMap(i -> b[i], i -> i));

    int result = 1;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < visited.length; ++i) {
      if (!visited[i] && search(a, bValueToIndex, d, visited, i) && a[i] != b[i]) {
        result = multiplyMod(result, 2);
      }
    }

    return result;
  }

  static boolean search(
      int[] a, Map<Integer, Integer> bValueToIndex, int[] d, boolean[] visited, int index) {
    visited[index] = true;

    boolean result = d[index] == 0;
    int nextIndex = bValueToIndex.get(a[index]);
    if (!visited[nextIndex]) {
      result &= search(a, bValueToIndex, d, visited, nextIndex);
    }

    return result;
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}