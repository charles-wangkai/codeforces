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

    if (table[0][0] == '1') {
      return "-1";
    }

    List<String> operations = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      for (int c = m - 1; c >= 1; --c) {
        if (table[r][c] == '1') {
          operations.add(String.format("%d %d %d %d", r + 1, c, r + 1, c + 1));
        }
      }
    }
    for (int r = n - 1; r >= 1; --r) {
      if (table[r][0] == '1') {
        operations.add(String.format("%d 1 %d 1", r, r + 1));
      }
    }

    return String.format("%d\n%s", operations.size(), String.join("\n", operations));
  }
}