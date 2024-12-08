import java.util.Scanner;
import java.util.stream.IntStream;

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
    return IntStream.range(0, a.length)
        .filter(
            i ->
                IntStream.range(0, a.length)
                    .allMatch(j -> j == i || Math.abs(a[j] - a[i]) % k != 0))
        .mapToObj(i -> "YES\n%d".formatted(i + 1))
        .findAny()
        .orElse("NO");
  }
}