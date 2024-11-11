import java.util.Scanner;

public class Main {
  static final int LIMIT = 10;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, int a, int b) {
    int x = 0;
    int y = 0;
    for (char move : s.repeat(LIMIT * 2).toCharArray()) {
      if (move == 'N') {
        ++y;
      } else if (move == 'E') {
        ++x;
      } else if (move == 'S') {
        --y;
      } else {
        --x;
      }

      if (x == a && y == b) {
        return true;
      }
    }

    return false;
  }
}