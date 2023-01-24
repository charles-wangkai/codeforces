import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String[] wall = new String[2];
      for (int i = 0; i < wall.length; ++i) {
        wall[i] = sc.next();
      }

      System.out.println(solve(wall) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String[] wall) {
    return check(wall, 0) || check(wall, 1);
  }

  static boolean check(String[] wall, int r) {
    for (int c = 0; c < wall[0].length(); ++c) {
      if (wall[r].charAt(c) == 'W') {
        return false;
      }

      if (wall[1 - r].charAt(c) == 'B') {
        r = 1 - r;
      }
    }

    return true;
  }
}
