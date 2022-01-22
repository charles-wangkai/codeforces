import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static String solve(int n, int m) {
    return IntStream.range(0, n * m)
        .map(
            i -> {
              int r = i / m;
              int c = i % m;

              return Math.max(r, n - 1 - r) + Math.max(c, m - 1 - c);
            })
        .boxed()
        .sorted()
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}