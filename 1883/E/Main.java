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
    int operationNum = 0;
    for (int i = 1; i < a.length; ++i) {
      operationNum = Math.max(0, operationNum + computeDelta(a[i - 1], a[i]));
      result += operationNum;
    }

    return result;
  }

  static int computeDelta(int value1, int value2) {
    int result = 0;
    while (value1 > value2) {
      value2 *= 2;
      ++result;
    }
    while (value1 * 2 <= value2) {
      value1 *= 2;
      --result;
    }

    return result;
  }
}