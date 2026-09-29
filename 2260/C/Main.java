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
    int maxXor = x + y;
    int subtracted = 0;
    for (int b = 30; b >= 0; --b) {
      if (((maxXor >> b) & 1) == 1 && subtracted + (1 << b) <= x) {
        subtracted += 1 << b;
      }
    }

    return "%d %d".formatted(maxXor, x - subtracted);
  }
}