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
    for (int i = 0; i < a.length - 1; ++i) {
      for (int j = i + 1; j < a.length - 1; ++j) {
        if (a[i] + a[j] > a[a.length - 1]) {
          ++result;
        }

        result += Math.max(0, findMaxIndex(a, i, j) - findMinIndex(a, i, j) + 1);
      }
    }

    return result;
  }

  static int findMinIndex(int[] a, int index1, int index2) {
    int result = a.length;
    int lower = index2 + 1;
    int upper = a.length - 2;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (a[index1] + a[index2] + a[middle] > a[a.length - 1]) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static int findMaxIndex(int[] a, int index1, int index2) {
    int result = -1;
    int lower = index2 + 1;
    int upper = a.length - 2;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (a[middle] < a[index1] + a[index2]) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}