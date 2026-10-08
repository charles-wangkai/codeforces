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

  static long solve(int[] a) {
    long result = computeSameParityPairNum(a, 0) + computeSameParityPairNum(a, 1);

    Map<Integer, Integer> evenLoveToCount = buildLoveToCount(a, 0);
    Map<Integer, Integer> oddLoveToCount = buildLoveToCount(a, 1);
    result +=
        evenLoveToCount.keySet().stream()
            .mapToLong(
                love -> (long) evenLoveToCount.get(love) * oddLoveToCount.getOrDefault(love, 0))
            .sum();

    return result;
  }

  static Map<Integer, Integer> buildLoveToCount(int[] a, int beginIndex) {
    Map<Integer, Integer> loveToCount = new HashMap<>();
    for (int i = beginIndex; i + 4 < a.length; i += 2) {
      updateMap(loveToCount, computeLove(a, i), 1);
    }

    return loveToCount;
  }

  static long computeSameParityPairNum(int[] a, int beginIndex) {
    long result = 0;
    Map<Integer, Integer> loveToCount = new HashMap<>();
    for (int i = beginIndex; i + 4 < a.length; i += 2) {
      if (i >= 6) {
        updateMap(loveToCount, computeLove(a, i - 6), 1);
      }

      result += loveToCount.getOrDefault(computeLove(a, i), 0);
    }

    return result;
  }

  static int computeLove(int[] a, int firstIndex) {
    return a[firstIndex] + a[firstIndex + 2] - a[firstIndex + 4];
  }

  static void updateMap(Map<Integer, Integer> loveToCount, int love, int delta) {
    loveToCount.put(love, loveToCount.getOrDefault(love, 0) + delta);
    loveToCount.remove(love, 0);
  }
}