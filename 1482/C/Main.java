import java.util.Arrays;
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
      int m = sc.nextInt();
      int[][] f = new int[m][];
      for (int i = 0; i < f.length; ++i) {
        int k = sc.nextInt();
        f[i] = new int[k];
        for (int j = 0; j < f[i].length; ++j) {
          f[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(n, f));
    }

    sc.close();
  }

  static String solve(int n, int[][] f) {
    int m = f.length;

    int limit = Math.ceilDiv(m, 2);

    int[] c = new int[m];
    Map<Integer, Integer> chosenToCount = new HashMap<>();
    for (int i = 0; i < f.length; ++i) {
      if (f[i].length == 1) {
        c[i] = f[i][0];
        chosenToCount.put(f[i][0], chosenToCount.getOrDefault(f[i][0], 0) + 1);
      }
    }

    if (chosenToCount.values().stream().anyMatch(count -> count > limit)) {
      return "NO";
    }

    for (int i = 0; i < f.length; ++i) {
      if (f[i].length != 1) {
        for (int fij : f[i]) {
          if (chosenToCount.getOrDefault(fij, 0) != limit) {
            c[i] = fij;
            chosenToCount.put(fij, chosenToCount.getOrDefault(fij, 0) + 1);

            break;
          }
        }
      }
    }

    return "YES\n%s"
        .formatted(Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}