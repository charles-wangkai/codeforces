import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int x) {
    int result = 0;
    int[] levels = new int[3];
    while (levels[0] != x) {
      levels[0] = Math.min(x, levels[1] * 2 + 1);
      Arrays.sort(levels);

      ++result;
    }

    return result;
  }
}