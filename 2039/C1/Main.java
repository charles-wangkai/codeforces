import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      long m = sc.nextLong();

      System.out.println(solve(x, m));
    }

    sc.close();
  }

  static int solve(int x, long m) {
    return (int)
        IntStream.rangeClosed(1, (int) Math.min(m, 2 * x))
            .filter(y -> y != x && (x % (x ^ y) == 0 || y % (x ^ y) == 0))
            .count();
  }
}