import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int w = sc.nextInt();
    int h = sc.nextInt();
    char[][] image = new char[h][w];
    for (int r = 0; r < h; ++r) {
      String line = sc.next();
      for (int c = 0; c < w; ++c) {
        image[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(image));

    sc.close();
  }

  static String solve(char[][] image) {
    return Arrays.stream(zoom(flip(rotate(image))))
        .map(String::new)
        .collect(Collectors.joining("\n"));
  }

  static char[][] rotate(char[][] image) {
    int h = image.length;
    int w = image[0].length;

    char[][] result = new char[w][h];
    for (int r = 0; r < result.length; ++r) {
      for (int c = 0; c < result[r].length; ++c) {
        result[r][c] = image[h - 1 - c][r];
      }
    }

    return result;
  }

  static char[][] flip(char[][] image) {
    int h = image.length;
    int w = image[0].length;

    char[][] result = new char[h][w];
    for (int r = 0; r < h; ++r) {
      for (int c = 0; c < w; ++c) {
        result[r][c] = image[r][w - 1 - c];
      }
    }

    return result;
  }

  static char[][] zoom(char[][] image) {
    int h = image.length;
    int w = image[0].length;

    char[][] result = new char[h * 2][w * 2];
    for (int r = 0; r < h; ++r) {
      for (int c = 0; c < w; ++c) {
        for (int dr = 0; dr < 2; ++dr) {
          for (int dc = 0; dc < 2; ++dc) {
            result[r * 2 + dr][c * 2 + dc] = image[r][c];
          }
        }
      }
    }

    return result;
  }
}