import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();

      System.out.println(solve(n, x, y, z));
    }

    sc.close();
  }

  static int solve(int n, int x, int y, int z) {
    return Math.min(computeTimeWithoutAI(n, x, y), computeTimeWithAI(n, x, y, z));
  }

  static int computeTimeWithoutAI(int n, int x, int y) {
    int result = 0;
    while (n > 0) {
      n -= x + y;

      ++result;
    }

    return result;
  }

  static int computeTimeWithAI(int n, int x, int y, int z) {
    int result = 0;
    while (n > 0) {
      n -= x;
      if (result >= z) {
        n -= 10 * y;
      }

      ++result;
    }

    return result;
  }
}