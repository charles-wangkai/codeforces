import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int n = sc.nextInt();

    System.out.println(solve(A, B, n));

    sc.close();
  }

  static String solve(int A, int B, int n) {
    Integer X = findX(A, B, n);

    return (X == null) ? "No solution" : String.valueOf(X);
  }

  static Integer findX(int A, int B, int n) {
    if (A == 0) {
      return (B == 0) ? 0 : null;
    }

    double power = (double) B / A;
    int X = (int) Math.round(Math.pow(Math.abs(power), 1.0 / n)) * (int) Math.signum(power);

    return (A * IntStream.range(0, n).reduce(1, (acc, x) -> acc * X) == B) ? X : null;
  }
}