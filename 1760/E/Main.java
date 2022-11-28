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
    long result = computeInversionNum(a);

    int leftIndex = 0;
    while (leftIndex != a.length && a[leftIndex] == 1) {
      ++leftIndex;
    }
    if (leftIndex != a.length) {
      a[leftIndex] = 1;
      result = Math.max(result, computeInversionNum(a));
      a[leftIndex] = 0;
    }

    int rightIndex = a.length - 1;
    while (rightIndex != -1 && a[rightIndex] == 0) {
      --rightIndex;
    }
    if (rightIndex != -1) {
      a[rightIndex] = 0;
      result = Math.max(result, computeInversionNum(a));
    }

    return result;
  }

  static long computeInversionNum(int[] a) {
    long result = 0;
    int oneCount = 0;
    for (int ai : a) {
      if (ai == 0) {
        result += oneCount;
      } else {
        ++oneCount;
      }
    }

    return result;
  }
}
