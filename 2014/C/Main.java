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

  static long solve(int[] a) {
    if (a.length <= 2) {
      return -1;
    }

    Arrays.sort(a);

    return Math.max(0, 2L * a[a.length / 2] * a.length - Arrays.stream(a).asLongStream().sum() + 1);
  }
}