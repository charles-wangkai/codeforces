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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] dedup =
        IntStream.range(0, a.length)
            .filter(i -> i == 0 || a[i] != a[i - 1])
            .map(i -> a[i])
            .toArray();

    return (int)
        IntStream.range(0, dedup.length)
            .filter(
                i ->
                    i == 0
                        || i == dedup.length - 1
                        || Integer.signum(dedup[i] - dedup[i - 1])
                            == Integer.signum(dedup[i] - dedup[i + 1]))
            .count();
  }
}
