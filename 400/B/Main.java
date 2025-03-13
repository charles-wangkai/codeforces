import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] matrix = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        matrix[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(matrix));

    sc.close();
  }

  static int solve(char[][] matrix) {
    int[] distances =
        Arrays.stream(matrix)
            .mapToInt(
                line ->
                    IntStream.range(0, line.length).filter(i -> line[i] == 'S').findAny().getAsInt()
                        - IntStream.range(0, line.length)
                            .filter(i -> line[i] == 'G')
                            .findAny()
                            .getAsInt())
            .toArray();

    return Arrays.stream(distances).anyMatch(distance -> distance < 0)
        ? -1
        : (int) Arrays.stream(distances).distinct().count();
  }
}