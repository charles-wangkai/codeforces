import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};
  static final Map<Character, Integer> DIRECTION_TO_INDEX =
      Map.ofEntries(entry('U', 0), entry('D', 2), entry('L', 3), entry('R', 1));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] maze = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          maze[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(maze));
    }

    sc.close();
  }

  static int solve(char[][] maze) {
    int n = maze.length;
    int m = maze[0].length;

    boolean[][] escaped = buildEscaped(maze);

    int result = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        int r_ = r;
        int c_ = c;
        if (!escaped[r][c]
            && IntStream.range(0, R_OFFSETS.length)
                .anyMatch(
                    i -> {
                      int adjR = r_ + R_OFFSETS[i];
                      int adjC = c_ + C_OFFSETS[i];

                      return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && !escaped[adjR][adjC];
                    })) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean[][] buildEscaped(char[][] maze) {
    int n = maze.length;
    int m = maze[0].length;

    boolean[] escaped = new boolean[n * m];

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n * m];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (maze[r][c] != '?') {
          int index = DIRECTION_TO_INDEX.get(maze[r][c]);
          int adjR = r + R_OFFSETS[index];
          int adjC = c + C_OFFSETS[index];
          if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m) {
            adjLists[toIndex(m, adjR, adjC)].add(toIndex(m, r, c));
          } else {
            escaped[toIndex(m, r, c)] = true;
          }
        }
      }
    }

    for (int i = 0; i < escaped.length; ++i) {
      if (escaped[i]) {
        search(escaped, adjLists, i);
      }
    }

    boolean[][] result = new boolean[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        result[r][c] = escaped[toIndex(m, r, c)];
      }
    }

    return result;
  }

  static int toIndex(int m, int r, int c) {
    return r * m + c;
  }

  static void search(boolean[] escaped, List<Integer>[] adjLists, int node) {
    for (int adj : adjLists[node]) {
      if (!escaped[adj]) {
        escaped[adj] = true;
        search(escaped, adjLists, adj);
      }
    }
  }
}