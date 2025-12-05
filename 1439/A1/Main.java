import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] table = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          table[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(table));
    }

    sc.close();
  }

  static String solve(char[][] table) {
    int n = table.length;
    int m = table[0].length;

    List<String> operations = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (table[r][c] == '1') {
          int adjR = r + ((r == n - 1) ? -1 : 1);
          int adjC = c + ((c == m - 1) ? -1 : 1);

          addOperation(operations, r, c, adjR, adjC, r, adjC);
          addOperation(operations, r, c, adjR, adjC, adjR, c);
          addOperation(operations, r, c, r, adjC, adjR, c);
        }
      }
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }

  static void addOperation(
      List<String> operations, int r1, int c1, int r2, int c2, int r3, int c3) {
    operations.add("%d %d %d %d %d %d".formatted(r1 + 1, c1 + 1, r2 + 1, c2 + 1, r3 + 1, c3 + 1));
  }
}