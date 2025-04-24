import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int doubleN = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(doubleN, x, y) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int doubleN, int x, int y) {
    return !((x == doubleN / 2 || x == doubleN / 2 + 1)
        && (y == doubleN / 2 || y == doubleN / 2 + 1));
  }
}