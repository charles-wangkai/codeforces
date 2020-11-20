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
    int common = Math.min(x, y);

    return common * 2 + Math.max(0, 2 * (x + y - common * 2) - 1);
  }
}
