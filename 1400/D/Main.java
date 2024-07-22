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
    long result = 0;
    for (int leftIndex = 0; leftIndex < a.length; ++leftIndex) {
      Map<Integer, Integer> leftValueToCount = new HashMap<>();

      Map<Integer, Integer> rightValueToCount = new HashMap<>();
      for (int i = leftIndex + 2; i < a.length; ++i) {
        rightValueToCount.put(a[i], rightValueToCount.getOrDefault(a[i], 0) + 1);
      }

      int pairNum = 0;
      for (int rightIndex = leftIndex + 2; rightIndex < a.length; ++rightIndex) {
        pairNum -= leftValueToCount.getOrDefault(a[rightIndex], 0);
        rightValueToCount.put(a[rightIndex], rightValueToCount.get(a[rightIndex]) - 1);

        pairNum += rightValueToCount.getOrDefault(a[rightIndex - 1], 0);
        leftValueToCount.put(
            a[rightIndex - 1], leftValueToCount.getOrDefault(a[rightIndex - 1], 0) + 1);

        if (a[rightIndex] == a[leftIndex]) {
          result += pairNum;
        }
      }
    }

    return result;
  }
}