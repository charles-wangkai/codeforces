import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int a = sc.nextInt();

      System.out.println(solve(x, y, a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int x, int y, int a) {
    int rest = (a + 1) % (x + y);
    if (rest == 0) {
      rest = x + y;
    }

    return rest > x;
  }
}