import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[] a = new String[2 * n - 2];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.next();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String[] a) {
    Arrays.sort(a, Comparator.comparing(String::length));

    return IntStream.range(0, a.length / 2)
        .allMatch(i -> new StringBuilder(a[i * 2]).reverse().toString().equals(a[i * 2 + 1]));
  }
}
