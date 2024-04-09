import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, long k) {
    int result = 0;
    int leftIndex = 0;
    int rightIndex = a.length - 1;
    while (leftIndex <= rightIndex && k >= 2) {
      if (leftIndex == rightIndex) {
        int delta = (int) Math.min(a[leftIndex], k);

        a[leftIndex] -= delta;
        if (a[leftIndex] == 0) {
          ++leftIndex;
          ++result;
        }

        k -= delta;
      } else {
        int delta = (int) Math.min(Math.min(a[leftIndex], a[rightIndex]), k / 2);

        a[leftIndex] -= delta;
        if (a[leftIndex] == 0) {
          ++leftIndex;
          ++result;
        }

        a[rightIndex] -= delta;
        if (a[rightIndex] == 0) {
          --rightIndex;
          ++result;
        }

        k -= delta * 2;
      }
    }

    if (k != 0 && leftIndex <= rightIndex && a[leftIndex] == 1) {
      ++result;
    }

    return result;
  }
}