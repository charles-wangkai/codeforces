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
      int[] u = new int[m];
      int[] v = new int[m];
      for (int i = 0; i < m; ++i) {
        u[i] = sc.nextInt() - 1;
        v[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(n, u, v));
    }

    sc.close();
  }

  static String solve(int n, int[] u, int[] v) {
    int[] degrees = new int[n];
    for (int i = 0; i < u.length; ++i) {
      ++degrees[u[i]];
      ++degrees[v[i]];
    }

    Map<Integer, Integer> degreeToCount = new HashMap<>();
    for (int degree : degrees) {
      if (degree != 1) {
        degreeToCount.put(degree, degreeToCount.getOrDefault(degree, 0) + 1);
      }
    }

    return String.format(
        "%d %d",
        (degreeToCount.size() == 1)
            ? degreeToCount.keySet().iterator().next()
            : degreeToCount.keySet().stream()
                .filter(degree -> degreeToCount.get(degree) == 1)
                .findAny()
                .get(),
        degreeToCount.keySet().stream()
                .filter(degree -> degreeToCount.get(degree) != 1)
                .findAny()
                .get()
            - 1);
  }
}
