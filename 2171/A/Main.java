import java.util.Scanner;
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

  static int solve(int n) {
    return (int)
        IntStream.iterate(0, i -> i * 4 <= n, i -> i + 1).filter(i -> (n - i * 4) % 2 == 0).count();
  }
}