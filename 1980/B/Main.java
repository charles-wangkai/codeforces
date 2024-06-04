import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int f = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, f, k));
    }

    sc.close();
  }

  static String solve(int[] a, int f, int k) {
    if (Arrays.stream(a).filter(ai -> ai > a[f - 1]).count() >= k) {
      return "NO";
    }
    if (Arrays.stream(a).filter(ai -> ai >= a[f - 1]).count() <= k) {
      return "YES";
    }

    return "MAYBE";
  }
}