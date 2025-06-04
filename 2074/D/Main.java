import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }
      int[] r = new int[n];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }

      System.out.println(solve(x, r, m));
    }

    sc.close();
  }

  static long solve(int[] x, int[] r, int m) {
    Map<Integer, Integer> xToPointNum = new HashMap<>();
    for (int i = 0; i < x.length; ++i) {
      for (int j = x[i] - r[i]; j <= x[i] + r[i]; ++j) {
        long square = (long) r[i] * r[i] - (long) (j - x[i]) * (j - x[i]);
        int limit = (int) Math.round(Math.sqrt(square));
        if ((long) limit * limit > square) {
          --limit;
        }

        xToPointNum.put(j, Math.max(xToPointNum.getOrDefault(j, 0), 2 * limit + 1));
      }
    }

    return xToPointNum.values().stream().mapToInt(Integer::intValue).asLongStream().sum();
  }
}