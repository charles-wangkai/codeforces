import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] u = new int[m];
      int[] v = new int[m];
      for (int i = 0; i < m; ++i) {
        st = new StringTokenizer(br.readLine());
        u[i] = Integer.parseInt(st.nextToken());
        v[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(n, u, v));
    }
  }

  static int solve(int n, int[] u, int[] v) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int result = 1;
    int[] colors = new int[n];
    Arrays.fill(colors, -1);
    for (int i = 0; i < colors.length; ++i) {
      if (colors[i] == -1) {
        int[] counts = new int[2];
        if (!search(counts, adjLists, colors, i, 0)) {
          return 0;
        }

        result = multiplyMod(result, addMod(powMod(2, counts[0]), powMod(2, counts[1])));
      }
    }

    return result;
  }

  static boolean search(int[] counts, List<Integer>[] adjLists, int[] colors, int node, int color) {
    if (colors[node] == -1) {
      colors[node] = color;
      ++counts[color];

      for (int adj : adjLists[node]) {
        if (!search(counts, adjLists, colors, adj, 1 - color)) {
          return false;
        }
      }

      return true;
    }

    return colors[node] == color;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int powMod(int base, int exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
