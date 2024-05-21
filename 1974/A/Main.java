import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static int solve(int x, int y) {
    int result = (y + 1) / 2;
    result += (Math.max(0, x - (result * 15 - y * 4)) + 14) / 15;

    return result;
  }
}