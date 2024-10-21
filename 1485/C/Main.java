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

  static long solve(int x, int y) {
    long result = 0;
    for (int i = 1; i + 1 <= y && i * (i + 2) <= x; ++i) {
      result += Math.min(x / i, y + 1) - i - 1;
    }

    return result;
  }
}