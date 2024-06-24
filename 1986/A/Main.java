import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x1 = sc.nextInt();
      int x2 = sc.nextInt();
      int x3 = sc.nextInt();

      System.out.println(solve(x1, x2, x3));
    }

    sc.close();
  }

  static int solve(int x1, int x2, int x3) {
    return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
  }
}