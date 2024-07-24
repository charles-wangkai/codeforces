import java.util.Comparator;
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

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    Map<Integer, Integer> rcSumToCount = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        int rcSum = r + c;
        rcSumToCount.put(rcSum, rcSumToCount.getOrDefault(rcSum, 0) + 1);
      }
    }

    int[] counts =
        rcSumToCount.values().stream()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = 0;
    while (k != 0) {
      int current = Math.min(k, counts[result]);
      k -= current;
      ++result;
    }

    return result;
  }
}