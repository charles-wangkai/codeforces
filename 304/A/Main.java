import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    int result = 0;
    for (int c = 1; c <= n; ++c) {
      for (int a = 1; a * a * 2 <= c * c; ++a) {
        if (isSquare(c * c - a * a)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean isSquare(int x) {
    int root = (int) Math.round(Math.sqrt(x));

    return root * root == x;
  }
}