import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    char[][][] squares = new char[n][2][2];
    for (int i = 0; i < n; ++i) {
      if (i != 0) {
        sc.next();
      }

      for (int r = 0; r < 2; ++r) {
        String line = sc.next();
        for (int c = 0; c < 2; ++c) {
          squares[i][r][c] = line.charAt(c);
        }
      }
    }

    System.out.println(solve(squares));

    sc.close();
  }

  static int solve(char[][][] squares) {
    return (int) Arrays.stream(squares).mapToInt(Main::buildKey).distinct().count();
  }

  static int buildKey(char[][] square) {
    return Stream.of(
            "%c%c%c%c".formatted(square[0][0], square[0][1], square[1][1], square[1][0]),
            "%c%c%c%c".formatted(square[0][1], square[1][1], square[1][0], square[0][0]),
            "%c%c%c%c".formatted(square[1][1], square[1][0], square[0][0], square[0][1]),
            "%c%c%c%c".formatted(square[1][0], square[0][0], square[0][1], square[1][1]))
        .mapToInt(Integer::parseInt)
        .min()
        .getAsInt();
  }
}