import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static long solve(int n) {
    return C(n - 1, n / 2) * P(n / 2 - 1) * P(n / 2 - 1);
  }

  static long P(int x) {
    return IntStream.rangeClosed(1, x).asLongStream().reduce(1, (result, elem) -> result * elem);
  }

  static long C(int n, int r) {
    return P(n) / P(r) / P(n - r);
  }
}
