import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int C = sc.nextInt();
    char[][] wall = new char[R][C];
    for (int r = 0; r < R; ++r) {
      String line = sc.next();
      for (int c = 0; c < C; ++c) {
        wall[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(wall));

    sc.close();
  }

  static int solve(char[][] wall) {
    return (int)
        IntStream.range(0, wall[wall.length - 1].length)
            .filter(
                c ->
                    wall[wall.length - 1][c] == 'B'
                        && (c == 0 || wall[wall.length - 1][c - 1] == '.'))
            .count();
  }
}