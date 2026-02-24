import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int x, int y) {
    return x + y >= 0 && (x + y) % 3 == 0 && Math.abs(y) <= (x + y) / 3;
  }
}