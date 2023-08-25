import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "vika";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] carpet = new char[n][m];
      for (int r = 0; r < carpet.length; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          carpet[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(carpet) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char[][] carpet) {
    int n = carpet.length;
    int m = carpet[0].length;

    int index = 0;
    for (int c = 0; c < m; ++c) {
      int c_ = c;
      int index_ = index;
      if (index != TARGET.length()
          && IntStream.range(0, n).anyMatch(r -> carpet[r][c_] == TARGET.charAt(index_))) {
        ++index;
      }
    }

    return index == TARGET.length();
  }
}
