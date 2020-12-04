import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int r = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(n, m, r, c));
    }

    sc.close();
  }

  static int solve(int n, int m, int r, int c) {
    return Math.max(
        Math.max(computeDistance(1, 1, r, c), computeDistance(1, m, r, c)),
        Math.max(computeDistance(n, 1, r, c), computeDistance(n, m, r, c)));
  }

  static int computeDistance(int x, int y, int r, int c) {
    return Math.abs(x - r) + Math.abs(y - c);
  }
}
