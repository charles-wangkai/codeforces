import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] S = new int[n];
      for (int i = 0; i < S.length; ++i) {
        S[i] = sc.nextInt();
      }
      int[] T = new int[n];
      for (int i = 0; i < T.length; ++i) {
        T[i] = sc.nextInt();
      }

      System.out.println(solve(S, T, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] S, int[] T, int k) {
    return buildKeyToCount(k, S).equals(buildKeyToCount(k, T));
  }

  static Map<Integer, Integer> buildKeyToCount(int k, int[] values) {
    Map<Integer, Integer> keyToCount = new HashMap<>();
    for (int value : values) {
      int key = Math.min(value % k, k - value % k);
      keyToCount.put(key, keyToCount.getOrDefault(key, 0) + 1);
    }

    return keyToCount;
  }
}