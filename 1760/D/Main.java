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
    int[] uniqs =
        IntStream.range(0, a.length)
            .filter(i -> i == 0 || a[i] != a[i - 1])
            .map(i -> a[i])
            .toArray();

    return IntStream.range(0, uniqs.length)
            .filter(
                i ->
                    (i == 0 || uniqs[i - 1] > uniqs[i])
                        && (i == uniqs.length - 1 || uniqs[i + 1] > uniqs[i]))
            .count()
        == 1;
  }
}
