import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    char[][][] pieces = new char[4][n][n];
    for (int i = 0; i < pieces.length; ++i) {
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          pieces[i][r][c] = line.charAt(c);
        }
      }
    }

    System.out.println(solve(pieces));

    sc.close();
  }

  static int solve(char[][][] pieces) {
    return search(pieces, IntStream.range(0, pieces.length).toArray(), 0);
  }

  static int search(char[][][] pieces, int[] indices, int depth) {
    if (depth == indices.length) {
      return Stream.of('0', '1')
          .mapToInt(evenTarget -> computeDiffCount(pieces, indices, evenTarget))
          .min()
          .getAsInt();
    }

    int result = Integer.MAX_VALUE;
    for (int i = depth; i < indices.length; ++i) {
      swap(indices, i, depth);
      result = Math.min(result, search(pieces, indices, depth + 1));
      swap(indices, i, depth);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static int computeDiffCount(char[][][] pieces, int[] indices, char evenTarget) {
    int n = pieces[0].length;

    int result = 0;
    for (int r = 0; r < 2 * n; ++r) {
      for (int c = 0; c < 2 * n; ++c) {
        if (getSquare(pieces, indices, r, c)
            != (((r + c) % 2 == 0) ? evenTarget : ('0' + '1' - evenTarget))) {
          ++result;
        }
      }
    }

    return result;
  }

  static char getSquare(char[][][] pieces, int[] indices, int r, int c) {
    int n = pieces[0].length;

    if (r < n) {
      return (c < n) ? pieces[indices[0]][r][c] : pieces[indices[1]][r][c - n];
    }

    return (c < n) ? pieces[indices[2]][r - n][c] : pieces[indices[3]][r - n][c - n];
  }
}