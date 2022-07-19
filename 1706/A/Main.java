import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static String solve(int[] a, int m) {
    char[] result = new char[m];
    Arrays.fill(result, 'B');
    for (int ai : a) {
      int minIndex = Math.min(ai - 1, m - ai);
      int maxIndex = Math.max(ai - 1, m - ai);

      if (result[minIndex] == 'B') {
        result[minIndex] = 'A';
      } else {
        result[maxIndex] = 'A';
      }
    }

    return new String(result);
  }
}