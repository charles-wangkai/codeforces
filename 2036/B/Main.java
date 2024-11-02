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
      int[] b = new int[k];
      int[] c = new int[k];
      for (int i = 0; i < k; ++i) {
        b[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(n, b, c));
    }

    sc.close();
  }

  static int solve(int n, int[] b, int[] c) {
    Map<Integer, Integer> brandToCostSum = new HashMap<>();
    for (int i = 0; i < b.length; ++i) {
      brandToCostSum.put(b[i], brandToCostSum.getOrDefault(b[i], 0) + c[i]);
    }

    return brandToCostSum.values().stream()
        .sorted(Comparator.reverseOrder())
        .limit(n)
        .mapToInt(Integer::intValue)
        .sum();
  }
}