import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] pieces = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        pieces[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(pieces) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(char[][] pieces) {
    int n = pieces.length;
    int m = pieces[0].length;

    int minR = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxC = Integer.MIN_VALUE;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (pieces[r][c] == 'X') {
          minR = Math.min(minR, r);
          maxR = Math.max(maxR, r);
          minC = Math.min(minC, c);
          maxC = Math.max(maxC, c);
        }
      }
    }

    for (int r = minR; r <= maxR; ++r) {
      for (int c = minC; c <= maxC; ++c) {
        if (pieces[r][c] == '.') {
          return false;
        }
      }
    }

    return true;
  }
}