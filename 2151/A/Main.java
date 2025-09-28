import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(int n, int[] a) {
    if (IntStream.range(0, a.length - 1).anyMatch(i -> a[i] >= a[i + 1])) {
      return 1;
    }

    return n - a[a.length - 1] + 1;
  }
}