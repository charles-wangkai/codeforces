import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] vertices = new int[x];
      for (int i = 0; i < vertices.length; ++i) {
        vertices[i] = sc.nextInt();
      }

      System.out.println(solve(n, vertices, y));
    }

    sc.close();
  }

  static int solve(int n, int[] vertices, int y) {
    Arrays.sort(vertices);

    return (vertices.length - 2)
        + (int)
            IntStream.range(0, vertices.length)
                .filter(i -> (vertices[(i + 1) % vertices.length] - vertices[i] + n) % n == 2)
                .count();
  }
}