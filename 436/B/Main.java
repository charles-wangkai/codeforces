import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    char[][] field = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        field[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(field, k));

    sc.close();
  }

  static String solve(char[][] field, int k) {
    int n = field.length;
    int m = field[0].length;

    int[] result = new int[m];
    for (int r = 1; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (field[r][c] == 'R') {
          if (c + r < result.length) {
            ++result[c + r];
          }
        } else if (field[r][c] == 'L') {
          if (c - r >= 0) {
            ++result[c - r];
          }
        } else if (field[r][c] == 'U' && r % 2 == 0) {
          ++result[c];
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}