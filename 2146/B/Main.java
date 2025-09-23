import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] S = new int[n][];
      for (int i = 0; i < S.length; ++i) {
        int l = sc.nextInt();
        S[i] = new int[l];
        for (int j = 0; j < S[i].length; ++j) {
          S[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(S, m) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] S, int m) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int[] Si : S) {
      for (int Sij : Si) {
        valueToCount.put(Sij, valueToCount.getOrDefault(Sij, 0) + 1);
      }
    }

    return IntStream.rangeClosed(1, m).allMatch(valueToCount::containsKey)
        && Arrays.stream(S)
                .filter(Si -> Arrays.stream(Si).allMatch(Sij -> valueToCount.get(Sij) >= 2))
                .count()
            >= 2;
  }
}