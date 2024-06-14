import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] image = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        image[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(image));

    sc.close();
  }

  static String solve(char[][] image) {
    int n = image.length;
    int m = image[0].length;

    int[] heights =
        IntStream.range(0, m)
            .map(c -> (int) IntStream.range(0, n).filter(r -> image[r][c] == '*').count())
            .toArray();

    return String.format(
        "%d %d",
        IntStream.range(0, heights.length - 1)
            .map(i -> Math.max(0, heights[i + 1] - heights[i]))
            .max()
            .orElse(0),
        IntStream.range(0, heights.length - 1)
            .map(i -> Math.max(0, heights[i] - heights[i + 1]))
            .max()
            .orElse(0));
  }
}