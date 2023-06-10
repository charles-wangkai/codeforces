import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int a, int b) {
    int result = 0;
    for (int divisor : new int[] {2, 3, 5}) {
      int aExponent = 0;
      while (a % divisor == 0) {
        ++aExponent;
        a /= divisor;
      }

      int bExponent = 0;
      while (b % divisor == 0) {
        ++bExponent;
        b /= divisor;
      }

      result += Math.abs(aExponent - bExponent);
    }

    return (a == b) ? result : -1;
  }
}
