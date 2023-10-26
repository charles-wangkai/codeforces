import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    Map<Integer, Integer> primeToCount = new HashMap<>();
    for (int ai : a) {
      for (int i = 2; i * i <= ai; ++i) {
        while (ai % i == 0) {
          primeToCount.put(i, primeToCount.getOrDefault(i, 0) + 1);
          ai /= i;
        }
      }
      if (ai != 1) {
        primeToCount.put(ai, primeToCount.getOrDefault(ai, 0) + 1);
      }
    }

    return primeToCount.values().stream().allMatch(count -> count % a.length == 0);
  }
}
