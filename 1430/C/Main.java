import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    return String.format(
        "2\n%s",
        IntStream.range(0, n - 1)
            .mapToObj(i -> String.format("%d %d", n - i - 1, Math.min(n, n - i + 1)))
            .collect(Collectors.joining("\n")));
  }
}
