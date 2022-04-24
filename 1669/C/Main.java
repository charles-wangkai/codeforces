import java.util.Scanner;
import java.util.stream.IntStream;

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
    return IntStream.range(0, a.length)
                .filter(i -> i % 2 == 0)
                .map(i -> a[i] % 2)
                .distinct()
                .count()
            == 1
        && IntStream.range(0, a.length)
                .filter(i -> i % 2 != 0)
                .map(i -> a[i] % 2)
                .distinct()
                .count()
            == 1;
  }
}