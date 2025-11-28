import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, int x, int y) {
    if (x == 0 && y == 0) {
      return true;
    }

    x = Math.abs(x);
    y = Math.abs(y);

    for (char c : s.toCharArray()) {
      if (c == '8') {
        if (x != 0) {
          --x;
        }
        if (y != 0) {
          --y;
        }
      } else if (x > y) {
        --x;
      } else {
        --y;
      }

      if (x == 0 && y == 0) {
        return true;
      }
    }

    return false;
  }
}