import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long m = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static long solve(int[] a, long m) {
    Map<Integer, Integer> petalToCount = new HashMap<>();
    for (int ai : a) {
      petalToCount.put(ai, petalToCount.getOrDefault(ai, 0) + 1);
    }

    return petalToCount.keySet().stream()
        .mapToLong(
            petal -> {
              int currCount = (int) Math.min(petalToCount.get(petal), m / petal);
              int nextCount =
                  (int)
                      Math.min(
                          petalToCount.getOrDefault(petal + 1, 0),
                          (m - (long) petal * currCount) / (petal + 1));

              int delta =
                  (int)
                      Math.min(
                          m - (long) petal * currCount - (petal + 1L) * nextCount,
                          Math.min(currCount, petalToCount.getOrDefault(petal + 1, 0) - nextCount));
              currCount -= delta;
              nextCount += delta;

              return (long) petal * currCount + (petal + 1L) * nextCount;
            })
        .max()
        .getAsLong();
  }
}