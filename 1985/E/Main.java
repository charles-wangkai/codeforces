import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
      long k = sc.nextLong();

      System.out.println(solve(x, y, z, k));
    }

    sc.close();
  }

  static long solve(int x, int y, int z, long k) {
    long result = 0;
    for (int a = 1; a <= x; ++a) {
      for (int b = 1; b <= y; ++b) {
        if (k % (a * b) == 0) {
          long c = k / (a * b);
          if (c <= z) {
            result = Math.max(result, (x - a + 1) * (y - b + 1) * (z - c + 1));
          }
        }
      }
    }

    return result;
  }
}