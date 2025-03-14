import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static int solve(int[] a, int k) {
    int result = -1;
    int lower = Arrays.stream(a).min().getAsInt();
    int upper = Arrays.stream(a).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, k, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int k, int targetCost) {
    return computeMaxLength(a, targetCost, false) >= k
        || computeMaxLength(a, targetCost, true) >= k;
  }

  static int computeMaxLength(int[] a, int targetCost, boolean constrained) {
    int result = 0;
    for (int ai : a) {
      if (constrained) {
        if (ai <= targetCost) {
          ++result;
          constrained = false;
        }
      } else {
        ++result;
        constrained = true;
      }
    }

    return result;
  }
}