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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    Map<Integer, Integer> primeFactorToCount = new HashMap<>();
    for (int value : a) {
      for (int i = 2; i * i <= value; ++i) {
        while (value % i == 0) {
          primeFactorToCount.put(i, primeFactorToCount.getOrDefault(i, 0) + 1);
          value /= i;
        }
      }
      if (value != 1) {
        primeFactorToCount.put(value, primeFactorToCount.getOrDefault(value, 0) + 1);
      }
    }

    return primeFactorToCount.values().stream().mapToInt(count -> count / 2).sum()
        + primeFactorToCount.values().stream().mapToInt(count -> count % 2).sum() / 3;
  }
}
