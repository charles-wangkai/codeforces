import java.util.Scanner;

public class Main {
  static final int SIZE = 3;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] matrix = new char[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      String line = sc.next();
      for (int c = 0; c < SIZE; ++c) {
        matrix[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(matrix) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(char[][] matrix) {
    for (int r = 0; r < SIZE; ++r) {
      for (int c = 0; c < SIZE; ++c) {
        if (matrix[r][c] != matrix[SIZE - 1 - r][SIZE - 1 - c]) {
          return false;
        }
      }
    }

    return true;
  }
}
