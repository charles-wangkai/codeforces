import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int n = s.length();

    int[] typeTwoPlayers = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '2').toArray();
    if (typeTwoPlayers.length == 1 || typeTwoPlayers.length == 2) {
      return "NO";
    }

    char[][] matrix = new char[n][n];
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        matrix[i][j] = (j == i) ? 'X' : '=';
      }
    }

    for (int i = 0; i < typeTwoPlayers.length; ++i) {
      int player1 = typeTwoPlayers[i];
      int player2 = typeTwoPlayers[(i + 1) % typeTwoPlayers.length];

      matrix[player1][player2] = '+';
      matrix[player2][player1] = '-';
    }

    return String.format(
        "YES\n%s", Arrays.stream(matrix).map(String::new).collect(Collectors.joining("\n")));
  }
}
