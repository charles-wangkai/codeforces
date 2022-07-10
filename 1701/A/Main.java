import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int[][] a = new int[2][2];
      for (int r = 0; r < a.length; ++r) {
        for (int c = 0; c < a[0].length; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int sum = Arrays.stream(a).mapToInt(line -> Arrays.stream(line).sum()).sum();

    if (sum == 0) {
      return 0;
    }
    if (sum == 4) {
      return 2;
    }

    return 1;
  }
}