import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();

    System.out.println(solve(n, x1, y1, x2, y2));

    sc.close();
  }

  static int solve(int n, int x1, int y1, int x2, int y2) {
    int distance = Math.abs(to1D(n, x1, y1) - to1D(n, x2, y2));

    return Math.min(distance, 4 * n - distance);
  }

  static int to1D(int n, int x, int y) {
    if (y == 0) {
      return x;
    }
    if (x == n) {
      return n + y;
    }
    if (y == n) {
      return 2 * n + (n - x);
    }

    return 3 * n + (n - y);
  }
}