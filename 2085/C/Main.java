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
    if (x == y) {
      return -1;
    }

    int max = Math.max(x, y);

    return Integer.highestOneBit(max) * 2 - max;
  }
}