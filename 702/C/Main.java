import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int result = -1;
    int lower = 0;
    int upper = Integer.MAX_VALUE;
    while (lower <= upper) {
      int middle = lower + (upper - lower) / 2;
      if (check(a, b, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int[] b, int r) {
    int aIndex = 0;
    for (int bi : b) {
      if (aIndex != a.length && a[aIndex] < (long) bi - r) {
        return false;
      }

      while (aIndex != a.length && a[aIndex] <= (long) bi + r) {
        ++aIndex;
      }
    }

    return aIndex == a.length;
  }
}
