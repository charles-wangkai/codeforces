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

  static String solve(int x, int y) {
    if ((x + y) % 2 != 0) {
      return "-1 -1";
    }
    if (x % 2 == 0) {
      return String.format("%d %d", x / 2, y / 2);
    }

    return String.format("%d %d", (x - 1) / 2, (y + 1) / 2);
  }
}
