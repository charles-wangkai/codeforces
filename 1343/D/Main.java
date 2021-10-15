import java.util.Scanner;

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

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    int[] deltas = new int[2 * k + 2];
    for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
      int lower1 = 1 + a[j];
      int upper1 = k + a[j];
      int lower2 = a[i] + 1;
      int upper2 = a[i] + k;
      if (lower1 <= lower2) {
        ++deltas[lower1];
        if (upper1 < lower2) {
          --deltas[upper1 + 1];

          ++deltas[lower2];
          --deltas[upper2 + 1];
        } else {
          --deltas[Math.max(upper1, upper2) + 1];
        }
      } else {
        ++deltas[lower2];
        if (upper2 < lower1) {
          --deltas[upper2 + 1];

          ++deltas[lower1];
          --deltas[upper1 + 1];
        } else {
          --deltas[Math.max(upper1, upper2) + 1];
        }
      }

      int sum = a[i] + a[j];
      ++deltas[sum];
      --deltas[sum + 1];
    }

    int maxSaveNum = 0;
    int saveNum = 0;
    for (int i = 1; i <= 2 * k; ++i) {
      saveNum += deltas[i];
      maxSaveNum = Math.max(maxSaveNum, saveNum);
    }

    return a.length - maxSaveNum;
  }
}
