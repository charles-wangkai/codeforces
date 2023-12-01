import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main implements Runnable {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    new Thread(null, new Main(), "Main", 1 << 27).start();
  }

  @Override
  public void run() {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    char[][] cells = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        cells[r][c] = line.charAt(c);
      }
    }
    int[] x = new int[k];
    int[] y = new int[k];
    for (int i = 0; i < k; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(cells, x, y));

    sc.close();
  }

  static String solve(char[][] cells, int[] x, int[] y) {
    int n = cells.length;
    int m = cells[0].length;

    int[][] groups = new int[n][m];
    for (int r = 0; r < n; ++r) {
      Arrays.fill(groups[r], -1);
    }

    List<Integer> pictureNums = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (cells[r][c] == '.' && groups[r][c] == -1) {
          int pictureNum = fill(cells, groups, pictureNums.size(), r, c);
          pictureNums.add(pictureNum);
        }
      }
    }

    return IntStream.range(0, x.length)
        .map(i -> pictureNums.get(groups[x[i] - 1][y[i] - 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int fill(char[][] cells, int[][] groups, int group, int r, int c) {
    groups[r][c] = group;

    int result = 0;
    for (int i = 0; i < R_OFFSETS.length; ++i) {
      int adjR = r + R_OFFSETS[i];
      int adjC = c + C_OFFSETS[i];
      if (cells[adjR][adjC] == '.') {
        if (groups[adjR][adjC] == -1) {
          result += fill(cells, groups, group, adjR, adjC);
        }
      } else {
        ++result;
      }
    }

    return result;
  }
}