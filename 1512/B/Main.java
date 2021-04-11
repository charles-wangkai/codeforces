import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] cells = new char[n][n];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          cells[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(cells));
    }

    sc.close();
  }

  static String solve(char[][] cells) {
    int n = cells.length;

    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (cells[r][c] == '*') {
          rows.add(r);
          cols.add(c);
        }
      }
    }

    int r1 = rows.stream().mapToInt(x -> x).min().getAsInt();
    int r2 = rows.stream().mapToInt(x -> x).max().getAsInt();
    if (r2 == r1) {
      r2 = (r2 + 1) % n;
    }

    int c1 = cols.stream().mapToInt(x -> x).min().getAsInt();
    int c2 = cols.stream().mapToInt(x -> x).max().getAsInt();
    if (c2 == c1) {
      c2 = (c2 + 1) % n;
    }

    for (int r : new int[] {r1, r2}) {
      for (int c : new int[] {c1, c2}) {
        cells[r][c] = '*';
      }
    }

    return Arrays.stream(cells).map(String::new).collect(Collectors.joining("\n"));
  }
}
