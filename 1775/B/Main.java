import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] p = new int[n][];
      for (int i = 0; i < p.length; ++i) {
        int k = sc.nextInt();
        p[i] = new int[k];
        for (int j = 0; j < p[i].length; ++j) {
          p[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(p) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[][] p) {
    Map<Integer, Integer> positionToCount = new HashMap<>();
    for (int[] pi : p) {
      for (int pij : pi) {
        positionToCount.put(pij, positionToCount.getOrDefault(pij, 0) + 1);
      }
    }

    return Arrays.stream(p)
        .anyMatch(pi -> Arrays.stream(pi).allMatch(pij -> positionToCount.get(pij) != 1));
  }
}
