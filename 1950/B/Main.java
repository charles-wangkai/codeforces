import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    char[][] result = new char[2 * n][2 * n];
    for (int r = 0; r < 2 * n; ++r) {
      for (int c = 0; c < 2 * n; ++c) {
        result[r][c] = ((r / 2 + c / 2) % 2 == 0) ? '#' : '.';
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}