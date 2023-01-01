import java.util.Arrays;
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
    Arrays.sort(a);

    int result = 0;
    while (check(a, result + 1)) {
      ++result;
    }

    return result;
  }

  static boolean check(int[] a, int k) {
    int index = a.length - 1;
    int beginIndex = 0;
    for (int i = k; i >= 1; --i) {
      while (index >= beginIndex && a[index] > i) {
        --index;
      }
      if (index < beginIndex) {
        return false;
      }

      --index;
      ++beginIndex;
    }

    return true;
  }
}
