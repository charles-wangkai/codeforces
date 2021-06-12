import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static long solve(int[] a, int l, int r) {
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

    long result = 0;
    for (int ai : a) {
      int minIndex = findGreaterEqual(sorted, l - ai);
      int maxIndex = findLessEqual(sorted, r - ai);
      if (minIndex != -1 && maxIndex != -1 && minIndex <= maxIndex) {
        result += maxIndex - minIndex + 1;
      }
    }
    for (int ai : a) {
      if (ai * 2 >= l && ai * 2 <= r) {
        --result;
      }
    }
    result /= 2;

    return result;
  }

  static int findGreaterEqual(int[] sorted, int target) {
    int result = -1;
    int lowerIndex = 0;
    int upperIndex = sorted.length - 1;
    while (lowerIndex <= upperIndex) {
      int middleIndex = (lowerIndex + upperIndex) / 2;
      if (sorted[middleIndex] >= target) {
        result = middleIndex;
        upperIndex = middleIndex - 1;
      } else {
        lowerIndex = middleIndex + 1;
      }
    }

    return result;
  }

  static int findLessEqual(int[] sorted, int target) {
    int result = -1;
    int lowerIndex = 0;
    int upperIndex = sorted.length - 1;
    while (lowerIndex <= upperIndex) {
      int middleIndex = (lowerIndex + upperIndex) / 2;
      if (sorted[middleIndex] <= target) {
        result = middleIndex;
        lowerIndex = middleIndex + 1;
      } else {
        upperIndex = middleIndex - 1;
      }
    }

    return result;
  }
}
