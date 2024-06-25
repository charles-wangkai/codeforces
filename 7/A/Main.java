import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int SIZE = 8;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] squares = new char[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      String line = sc.next();
      for (int c = 0; c < SIZE; ++c) {
        squares[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(squares));

    sc.close();
  }

  static int solve(char[][] squares) {
    int result = 0;
    for (int r = 0; r < SIZE; ++r) {
      if (new String(squares[r]).indexOf('W') == -1) {
        for (int c = 0; c < SIZE; ++c) {
          squares[r][c] = 'W';
        }
        ++result;
      }
    }
    for (int c = 0; c < SIZE; ++c) {
      int c_ = c;
      if (IntStream.range(0, SIZE).anyMatch(r -> squares[r][c_] == 'B')) {
        ++result;
      }
    }

    return result;
  }
}