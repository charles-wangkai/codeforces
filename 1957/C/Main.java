import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] r = new int[k];
      int[] c = new int[k];
      for (int i = 0; i < k; ++i) {
        r[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(n, r, c));
    }

    sc.close();
  }

  static int solve(int n, int[] r, int[] c) {
    return f(
        new HashMap<>(), n - IntStream.range(0, r.length).map(i -> (r[i] == c[i]) ? 1 : 2).sum());
  }

  static int f(Map<Integer, Integer> cache, int x) {
    if (x <= 1) {
      return 1;
    }

    if (!cache.containsKey(x)) {
      cache.put(x, addMod(f(cache, x - 1), multiplyMod(f(cache, x - 2), 2 * (x - 1))));
    }

    return cache.get(x);
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}