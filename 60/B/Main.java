import java.util.Scanner;

public class Main {
  static final int[] L_OFFSETS = {-1, 1, 0, 0, 0, 0};
  static final int[] R_OFFSETS = {0, 0, -1, 1, 0, 0};
  static final int[] C_OFFSETS = {0, 0, 0, 0, -1, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][][] plate = new char[k][n][m];
    for (int l = 0; l < k; ++l) {
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          plate[l][r][c] = line.charAt(c);
        }
      }
    }
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(plate, x, y));

    sc.close();
  }

  static int solve(char[][][] plate, int x, int y) {
    return fill(plate, 0, x - 1, y - 1);
  }

  static int fill(char[][][] plate, int l, int r, int c) {
    int k = plate.length;
    int n = plate[0].length;
    int m = plate[0][0].length;

    if (!(l >= 0 && l < k && r >= 0 && r < n && c >= 0 && c < m && plate[l][r][c] == '.')) {
      return 0;
    }

    plate[l][r][c] = '*';

    int result = 1;
    for (int i = 0; i < L_OFFSETS.length; ++i) {
      result += fill(plate, l + L_OFFSETS[i], r + R_OFFSETS[i], c + C_OFFSETS[i]);
    }

    return result;
  }
}