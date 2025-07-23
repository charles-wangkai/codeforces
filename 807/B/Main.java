import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int p = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(p, x, y));

    sc.close();
  }

  static int solve(int p, int x, int y) {
    for (int result = 0; ; ++result) {
      for (int s = x + result * 100; s >= y; s -= 50) {
        if (check(p, s)) {
          return result;
        }
      }
    }
  }

  static boolean check(int p, int s) {
    int i = s / 50 % 475;
    for (int j = 0; j < 25; ++j) {
      i = (i * 96 + 42) % 475;
      if (26 + i == p) {
        return true;
      }
    }

    return false;
  }
}