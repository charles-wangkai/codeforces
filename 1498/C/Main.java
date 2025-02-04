import java.util.Scanner;

public class Main implements Runnable {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    new Thread(null, new Main(), "Main", 1 << 28).start();
  }

  public void run() {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    return search(new int[n + 1][k + 1], n, n, k);
  }

  static int search(int[][] cache, int n, int planeNum, int k) {
    if (planeNum == 0) {
      return 1;
    }

    if (cache[planeNum][k] == 0) {
      cache[planeNum][k] =
          addMod(
              search(cache, n, planeNum - 1, k),
              (k == 1) ? 0 : search(cache, n, n - planeNum, k - 1));
    }

    return cache[planeNum][k];
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}
