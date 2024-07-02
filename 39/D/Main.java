import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] points = new int[2][3];
    for (int i = 0; i < points.length; ++i) {
      for (int j = 0; j < points[i].length; ++j) {
        points[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(points) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[][] points) {
    return IntStream.range(0, points[0].length).anyMatch(i -> points[0][i] == points[1][i]);
  }
}