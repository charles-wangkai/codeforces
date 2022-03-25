import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static int solve(int x, int y) {
    if (x == 0 && y == 0) {
      return 0;
    }

    return isSquare(x * x + y * y) ? 1 : 2;
  }

  static boolean isSquare(int a) {
    int root = (int) Math.round(Math.sqrt(a));

    return root * root == a;
  }
}