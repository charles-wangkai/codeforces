import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int row = (s.length() + 19) / 20;
    int col = (s.length() + row - 1) / row;

    char[][] table = new char[row][col];
    int index = 0;
    for (int r = 0; r < table.length; ++r) {
      Arrays.fill(table[r], '*');

      for (int c = 0; c < s.length() / row + ((r < s.length() % row) ? 1 : 0); ++c) {
        table[r][c] = s.charAt(index);
        ++index;
      }
    }

    return "%d %d\n%s"
        .formatted(
            row, col, Arrays.stream(table).map(String::new).collect(Collectors.joining("\n")));
  }
}