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

    int result = a.length;
    int endIndex = -1;
    for (int beginIndex = 0; beginIndex < a.length - 1; ++beginIndex) {
      while (endIndex != a.length - 1 && a[endIndex + 1] < a[beginIndex] + a[beginIndex + 1]) {
        ++endIndex;
      }

      result = Math.min(result, a.length - (endIndex - beginIndex + 1));
    }

    return result;
  }
}