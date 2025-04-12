import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] board = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          board[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(board));
    }

    sc.close();
  }

  static String solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;

    Map<Integer, List<Integer>> beginCToRs = new HashMap<>();
    Map<Integer, List<Integer>> beginRToCs = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (board[r][c] == 'L') {
          beginCToRs.putIfAbsent(c, new ArrayList<>());
          beginCToRs.get(c).add(r);
        } else if (board[r][c] == 'U') {
          beginRToCs.putIfAbsent(r, new ArrayList<>());
          beginRToCs.get(r).add(c);
        }
      }
    }

    if (Stream.concat(beginCToRs.values().stream(), beginRToCs.values().stream())
        .anyMatch(x -> x.size() % 2 == 1)) {
      return "-1";
    }

    char[][] result = new char[n][m];
    for (int r = 0; r < n; ++r) {
      Arrays.fill(result[r], '.');
    }
    for (int beginC : beginCToRs.keySet()) {
      List<Integer> rs = beginCToRs.get(beginC);
      for (int i = 0; i < rs.size(); ++i) {
        if (i % 2 == 0) {
          result[rs.get(i)][beginC] = 'B';
          result[rs.get(i)][beginC + 1] = 'W';
        } else {
          result[rs.get(i)][beginC] = 'W';
          result[rs.get(i)][beginC + 1] = 'B';
        }
      }
    }
    for (int beginR : beginRToCs.keySet()) {
      List<Integer> cs = beginRToCs.get(beginR);
      for (int i = 0; i < cs.size(); ++i) {
        if (i % 2 == 0) {
          result[beginR][cs.get(i)] = 'B';
          result[beginR + 1][cs.get(i)] = 'W';
        } else {
          result[beginR][cs.get(i)] = 'W';
          result[beginR + 1][cs.get(i)] = 'B';
        }
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}