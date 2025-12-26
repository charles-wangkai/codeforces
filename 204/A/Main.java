import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long l = sc.nextLong();
    long r = sc.nextLong();

    System.out.println(solve(l, r));

    sc.close();
  }

  static long solve(long l, long r) {
    return computeNum(r) - computeNum(l - 1);
  }

  static long computeNum(long x) {
    if (x == 0) {
      return 0;
    }

    String s = String.valueOf(x);
    int[] digits = s.chars().map(c -> c - '0').toArray();

    long result =
        IntStream.range(1, s.length()).mapToLong(length -> 9 * pow10(length - 2)).sum()
            + (digits[0] - 1) * pow10(s.length() - 2);
    if (s.length() <= 2) {
      if (digits[0] <= digits[digits.length - 1]) {
        ++result;
      }
    } else {
      result += Long.parseLong(s.substring(1, s.length() - 1)) + 1;
      if (digits[0] > digits[digits.length - 1]) {
        --result;
      }
    }

    return result;
  }

  static long pow10(int exponent) {
    long result = 1;
    for (int i = 0; i < exponent; ++i) {
      result *= 10;
    }

    return result;
  }
}