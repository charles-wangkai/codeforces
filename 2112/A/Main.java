import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(a, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int x, int y) {
    return IntStream.rangeClosed(Math.min(x, y), Math.max(x, y))
        .anyMatch(
            p -> p != a && Math.abs(p - x) < Math.abs(a - x) && Math.abs(p - y) < Math.abs(a - y));
  }
}