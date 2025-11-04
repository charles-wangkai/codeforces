import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {0, 1, 0, -1};
  static final int[] C_OFFSETS = {-1, 0, 1, 0};

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] tiles = new int[N][M];
    for (int r = 0; r < N; ++r) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; ++c) {
        tiles[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(tiles));
  }

  static String solve(int[][] tiles) {
    int N = tiles.length;
    int M = tiles[0].length;

    List<Integer> roomSizes = new ArrayList<>();
    boolean[][] visited = new boolean[N][M];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < M; ++c) {
        if (!visited[r][c]) {
          roomSizes.add(search(tiles, visited, r, c));
        }
      }
    }

    return roomSizes.stream()
        .sorted(Comparator.reverseOrder())
        .map(String::valueOf)
        .map(x -> x + " ")
        .collect(Collectors.joining());
  }

  static int search(int[][] tiles, boolean[][] visited, int r, int c) {
    if (visited[r][c]) {
      return 0;
    }

    visited[r][c] = true;

    int result = 1;
    for (int i = 0; i < R_OFFSETS.length; ++i) {
      if (((tiles[r][c] >> i) & 1) == 0) {
        result += search(tiles, visited, r + R_OFFSETS[i], c + C_OFFSETS[i]);
      }
    }

    return result;
  }
}