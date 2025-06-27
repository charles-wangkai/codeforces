import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(m, b));

    sc.close();
  }

  static long solve(int m, int b) {
    return IntStream.rangeClosed(0, b)
        .mapToLong(
            y -> {
              int x = (b - y) * m;

              return y * (y + 1L) / 2 * (x + 1) + x * (x + 1L) / 2 * (y + 1);
            })
        .max()
        .getAsLong();
  }
}