import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(n, x, y));
    }

    sc.close();
  }

  static String solve(int n, int x, int y) {
    if (x > y) {
      return solve(n, y, x);
    }
    if (x != 0 || y == 0 || (n - 1) % y != 0) {
      return "-1";
    }

    return IntStream.range(0, n - 1)
        .map(i -> 2 + i / y * y)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}