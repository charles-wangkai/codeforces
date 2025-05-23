import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    Arrays.sort(a);

    return (Math.max(a[a.length - 1] - 1, a[a.length - 2]) - a[0] <= k
            && Arrays.stream(a).asLongStream().sum() % 2 == 1)
        ? "Tom"
        : "Jerry";
  }
}