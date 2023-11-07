import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(x, y, k));
    }

    sc.close();
  }

  static int solve(int x, int y, int k) {
    return (x >= y) ? x : (y + (y - (x + Math.min(k, y - x))));
  }
}
