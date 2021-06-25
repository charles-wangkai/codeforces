import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int U = sc.nextInt();
      int R = sc.nextInt();
      int D = sc.nextInt();
      int L = sc.nextInt();

      System.out.println(solve(n, U, R, D, L) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int U, int R, int D, int L) {
    for (int ul = 0; ul <= 1; ++ul) {
      for (int ur = 0; ur <= 1; ++ur) {
        for (int dr = 0; dr <= 1; ++dr) {
          for (int dl = 0; dl <= 1; ++dl) {
            if (check(n, U, R, D, L, ul, ur, dr, dl)) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  static boolean check(int n, int U, int R, int D, int L, int ul, int ur, int dr, int dl) {
    int up = U - ul - ur;
    int right = R - ur - dr;
    int down = D - dr - dl;
    int left = L - ul - dl;

    return up >= 0
        && up <= n - 2
        && right >= 0
        && right <= n - 2
        && down >= 0
        && down <= n - 2
        && left >= 0
        && left <= n - 2;
  }
}
