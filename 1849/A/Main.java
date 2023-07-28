import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int b = sc.nextInt();
      int c = sc.nextInt();
      int h = sc.nextInt();

      System.out.println(solve(b, c, h));
    }

    sc.close();
  }

  static int solve(int b, int c, int h) {
    return Math.min(b - 1, c + h) * 2 + 1;
  }
}
