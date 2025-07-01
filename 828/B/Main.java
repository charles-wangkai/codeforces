import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] sheet = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        sheet[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(sheet));

    sc.close();
  }

  static int solve(char[][] sheet) {
    int n = sheet.length;
    int m = sheet[0].length;

    int blackCount = 0;
    int minR = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxC = Integer.MIN_VALUE;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (sheet[r][c] == 'B') {
          ++blackCount;
          minR = Integer.min(minR, r);
          maxR = Integer.max(maxR, r);
          minC = Integer.min(minC, c);
          maxC = Integer.max(maxC, c);
        }
      }
    }

    if (blackCount == 0) {
      return 1;
    }

    int size = Math.max(maxR - minR + 1, maxC - minC + 1);

    return (size <= n && size <= m) ? (size * size - blackCount) : -1;
  }
}