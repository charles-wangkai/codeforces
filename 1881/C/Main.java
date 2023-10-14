import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] matrix = new char[n][n];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          matrix[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(matrix));
    }

    sc.close();
  }

  static int solve(char[][] matrix) {
    int n = matrix.length;

    int result = 0;
    for (int r = 0; r < n / 2; ++r) {
      for (int c = 0; c < n / 2; ++c) {
        char[] letters = {
          matrix[r][c], matrix[c][n - 1 - r], matrix[n - 1 - r][n - 1 - c], matrix[n - 1 - c][r]
        };
        Arrays.sort(letters);

        result += (letters[3] - letters[0]) + (letters[3] - letters[1]) + (letters[3] - letters[2]);
      }
    }

    return result;
  }
}
