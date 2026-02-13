import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int DIGIT_SUM_LIMIT = 9 * 10;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int x) {
    return (int)
        IntStream.rangeClosed(0, DIGIT_SUM_LIMIT)
            .filter(delta -> (x + delta) - computeDigitSum(x + delta) == x)
            .count();
  }

  static int computeDigitSum(int y) {
    return String.valueOf(y).chars().map(c -> c - '0').sum();
  }
}