import java.util.Scanner;

public class Main {
  static final int SIZE = 3;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      char[][] square = new char[SIZE][SIZE];
      for (int r = 0; r < SIZE; ++r) {
        String line = sc.next();
        for (int c = 0; c < SIZE; ++c) {
          square[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(square));
    }

    sc.close();
  }

  static char solve(char[][] square) {
    char result = 'A' ^ 'B' ^ 'C' ^ '?';
    for (int r = 0; r < SIZE; ++r) {
      for (int c = 0; c < SIZE; ++c) {
        result ^= square[r][c];
      }
    }

    return result;
  }
}