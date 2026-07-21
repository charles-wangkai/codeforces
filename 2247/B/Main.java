import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, k, m));
    }

    sc.close();
  }

  static String solve(int n, int k, int m) {
    return (k <= m)
        ? "YES\n%s"
            .formatted(
                IntStream.range(0, n)
                    .map(i -> (i % k == k - 1) ? (m - (k - 1)) : 1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        : "NO";
  }
}