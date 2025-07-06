import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(a, b, x, y));
    }

    sc.close();
  }

  static int solve(int a, int b, int x, int y) {
    if (a / 2 > b / 2) {
      return -1;
    }
    if (a == b + 1) {
      return y;
    }

    int result = 0;
    while (a != b) {
      if (a % 2 == 0) {
        result += Math.min(x, y);
      } else {
        result += x;
      }

      ++a;
    }

    return result;
  }
}