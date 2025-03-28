import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long r = sc.nextLong();

    System.out.println(solve(r));

    sc.close();
  }

  static String solve(long r) {
    for (int x = 1; ; ++x) {
      long rest = r - (long) x * x - x - 1;
      if (rest <= 0) {
        return "NO";
      }

      if (rest % (2 * x) == 0) {
        long y = rest / (2 * x);

        return "%d %d".formatted(x, y);
      }
    }
  }
}