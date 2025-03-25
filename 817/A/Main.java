import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(x1, y1, x2, y2, x, y) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int x1, int y1, int x2, int y2, int x, int y) {
    return (x1 - x2) % x == 0
        && (y1 - y2) % y == 0
        && Math.abs(x1 - x2) / x % 2 == Math.abs(y1 - y2) / y % 2;
  }
}