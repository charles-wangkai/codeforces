import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(x, y, k));
    }

    sc.close();
  }

  static int solve(int x, int y, int k) {
    while (k != 0) {
      if (x == 1) {
        return (x - 1 + k) % (y - 1) + 1;
      }

      int delta = Math.min(k, (x % y == 0) ? y : Math.floorMod(-x, y));
      k -= delta;
      x += delta;
      while (x % y == 0) {
        x /= y;
      }
    }

    return x;
  }
}