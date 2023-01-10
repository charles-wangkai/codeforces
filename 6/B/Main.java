import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char color = sc.next().charAt(0);
    char[][] room = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        room[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(room, color));

    sc.close();
  }

  static int solve(char[][] room, char color) {
    int n = room.length;
    int m = room[0].length;

    Set<Character> deputyColors = new HashSet<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        int r_ = r;
        int c_ = c;
        if (room[r][c] != '.'
            && room[r][c] != color
            && IntStream.range(0, R_OFFSETS.length)
                .anyMatch(
                    i ->
                        r_ + R_OFFSETS[i] >= 0
                            && r_ + R_OFFSETS[i] < n
                            && c_ + C_OFFSETS[i] >= 0
                            && c_ + C_OFFSETS[i] < m
                            && room[r_ + R_OFFSETS[i]][c_ + C_OFFSETS[i]] == color)) {
          deputyColors.add(room[r][c]);
        }
      }
    }

    return deputyColors.size();
  }
}
