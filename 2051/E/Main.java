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
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int k) {
    Map<Integer, Integer> aToCount = new HashMap<>();
    for (int ai : a) {
      aToCount.put(ai, aToCount.getOrDefault(ai, 0) + 1);
    }

    Map<Integer, Integer> bToCount = new HashMap<>();
    for (int bi : b) {
      bToCount.put(bi, bToCount.getOrDefault(bi, 0) + 1);
    }

    int[] sorted =
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();

    long result = 0;
    int buyNum = a.length;
    int negativeNum = 0;
    for (int price : sorted) {
      if (negativeNum <= k) {
        result = Math.max(result, (long) price * buyNum);
      }

      negativeNum += aToCount.getOrDefault(price, 0) - bToCount.getOrDefault(price, 0);
      buyNum -= bToCount.getOrDefault(price, 0);
    }

    return result;
  }
}