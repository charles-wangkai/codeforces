import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int v = sc.nextInt();

    System.out.println(solve(k, a, b, v));

    sc.close();
  }

  static int solve(int k, int a, int b, int v) {
    int result = 0;
    while (a > 0) {
      ++result;
      int divisor = Math.min(b, k - 1);
      b -= divisor;
      a -= (divisor + 1) * v;
    }

    return result;
  }
}