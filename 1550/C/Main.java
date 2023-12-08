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

  static int solve(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length; ++i) {
      for (int j = i; j < a.length; ++j) {
        if (!isGood(a, i, j)) {
          break;
        }

        ++result;
      }
    }

    return result;
  }

  static boolean isGood(int[] a, int beginIndex, int endIndex) {
    for (int i = beginIndex; i < endIndex; ++i) {
      for (int j = i + 1; j < endIndex; ++j) {
        if ((a[i] <= a[j] && a[j] <= a[endIndex]) || (a[i] >= a[j] && a[j] >= a[endIndex])) {
          return false;
        }
      }
    }

    return true;
  }
}