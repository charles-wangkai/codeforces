import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int A) {
    int sum = IntStream.range(2, A).map(base -> computeDigitSum(A, base)).sum();
    int count = A - 2;
    int g = gcd(sum, count);

    return String.format("%d/%d", sum / g, count / g);
  }

  static int computeDigitSum(int A, int base) {
    int result = 0;
    while (A != 0) {
      result += A % base;
      A /= base;
    }

    return result;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}