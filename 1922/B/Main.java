import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

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
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    long result = 0;
    long sum = 0;
    for (int count : valueToCount.values()) {
      result += count * (count - 1L) * (count - 2) / 6 + count * (count - 1L) / 2 * sum;
      sum += count;
    }

    return result;
  }
}