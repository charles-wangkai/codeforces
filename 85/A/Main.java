import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    char[][] result = new char[4][n];

    if (n % 2 == 0) {
      for (int c = 0; c + 1 < n; c += 2) {
        result[0][c] = (c % 4 == 0) ? 'a' : 'b';
        result[0][c + 1] = result[0][c];

        result[3][c] = result[0][c];
        result[3][c + 1] = result[3][c];
      }

      result[1][0] = 'p';
      result[2][0] = 'p';
      result[1][n - 1] = 'q';
      result[2][n - 1] = 'q';
      for (int c = 1; c + 1 < n; c += 2) {
        result[1][c] = (c % 4 == 1) ? 'x' : 'y';
        result[1][c + 1] = result[1][c];

        result[2][c] = (char) ('x' + 'y' - result[1][c]);
        result[2][c + 1] = result[2][c];
      }
    } else {
      result[0][n - 1] = 'p';
      result[1][n - 1] = 'p';
      for (int c = 0; c + 1 < n - 1; c += 2) {
        result[0][c] = (c % 4 == 0) ? 'a' : 'b';
        result[0][c + 1] = result[0][c];

        result[1][c] = (char) ('a' + 'b' - result[0][c]);
        result[1][c + 1] = result[1][c];
      }

      result[2][0] = 'q';
      result[3][0] = 'q';
      for (int c = 1; c + 1 < n; c += 2) {
        result[2][c] = (c % 4 == 1) ? 'x' : 'y';
        result[2][c + 1] = result[2][c];

        result[3][c] = (char) ('x' + 'y' - result[2][c]);
        result[3][c + 1] = result[3][c];
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}