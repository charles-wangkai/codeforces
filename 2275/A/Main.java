import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x0 = sc.nextInt();
      int y0 = sc.nextInt();
      int R = sc.nextInt();

      System.out.println(solve(x0, y0, R));
    }

    sc.close();
  }

  static String solve(int x0, int y0, int R) {
    return "%d %d".formatted(x0 + R, y0);
  }
}