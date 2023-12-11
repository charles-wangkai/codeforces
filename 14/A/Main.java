import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(char[][] sheet) {
    int n = sheet.length;
    int m = sheet[0].length;

    int minR = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxC = Integer.MIN_VALUE;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (sheet[r][c] == '*') {
          minR = Math.min(minR, r);
          maxR = Math.max(maxR, r);
          minC = Math.min(minC, c);
          maxC = Math.max(maxC, c);
        }
      }
    }

    int row = maxR - minR + 1;
    int col = maxC - minC + 1;
    char[][] result = new char[row][col];
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        result[r][c] = sheet[minR + r][minC + c];
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}