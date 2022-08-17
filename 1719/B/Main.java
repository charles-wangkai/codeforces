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

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    if (k % 2 != 0) {
      return String.format(
          "YES\n%s",
          IntStream.range(0, n / 2)
              .mapToObj(i -> String.format("%d %d", 2 * i + 1, 2 * i + 2))
              .collect(Collectors.joining("\n")));
    }
    if (k % 4 == 2) {
      return String.format(
          "YES\n%s",
          IntStream.range(0, n / 2)
              .mapToObj(
                  i ->
                      (i % 2 == 0)
                          ? String.format("%d %d", 2 * i + 2, 2 * i + 1)
                          : String.format("%d %d", 2 * i + 1, 2 * i + 2))
              .collect(Collectors.joining("\n")));
    }

    return "NO";
  }
}