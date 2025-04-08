import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, a));
    }

    sc.close();
  }

  static long solve(int n, int[] a) {
    Arrays.sort(a);

    long result = 0;
    int leftIndex = 0;
    int rightIndex = a.length;
    int bothIndex = a.length;
    for (int leftLength = 1; leftLength < n; ++leftLength) {
      while (leftIndex != a.length && a[leftIndex] < leftLength) {
        ++leftIndex;
      }

      int rightLength = n - leftLength;
      while (rightIndex != 0 && a[rightIndex - 1] >= rightLength) {
        --rightIndex;
      }

      int bothLength = Math.max(leftLength, rightLength);
      while (bothIndex != 0 && a[bothIndex - 1] >= bothLength) {
        --bothIndex;
      }
      while (bothIndex != a.length && a[bothIndex] < bothLength) {
        ++bothIndex;
      }

      result += (long) (a.length - leftIndex) * (a.length - rightIndex) - (a.length - bothIndex);
    }

    return result;
  }
}