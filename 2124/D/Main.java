import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

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

      System.out.println(solve(a, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int k) {
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    int countSum = 0;
    int maxValue = -1;
    for (int value : valueToCount.keySet()) {
      countSum += valueToCount.get(value);
      if (countSum >= k) {
        maxValue = value;

        break;
      }
    }

    int maxValue_ = maxValue;
    int[] stripped = Arrays.stream(a).filter(ai -> ai <= maxValue_).toArray();
    int leftIndex = 0;
    int rightIndex = stripped.length - 1;
    int keptCount = 0;
    while (leftIndex <= rightIndex) {
      if (stripped[leftIndex] == stripped[rightIndex]) {
        if (stripped[leftIndex] == maxValue) {
          ++keptCount;
        }
        if (stripped[rightIndex] == maxValue && rightIndex != leftIndex) {
          ++keptCount;
        }

        ++leftIndex;
        --rightIndex;
      } else if (stripped[leftIndex] == maxValue) {
        ++leftIndex;
      } else if (stripped[rightIndex] == maxValue) {
        --rightIndex;
      } else {
        return false;
      }
    }

    return countSum - valueToCount.get(maxValue) + keptCount >= k - 1;
  }
}