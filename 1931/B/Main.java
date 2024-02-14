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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int average = (int) (Arrays.stream(a).asLongStream().sum() / a.length);
    int sum = 0;
    for (int i = a.length - 1; i >= 0; --i) {
      sum += a[i];
      if (sum > (long) (a.length - i) * average) {
        return false;
      }
    }

    return true;
  }
}