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
    return (n % 7 == 0)
        ? n
        : IntStream.range(n / 10 * 10, n / 10 * 10 + 10)
            .filter(x -> x % 7 == 0)
            .findAny()
            .getAsInt();
  }
}