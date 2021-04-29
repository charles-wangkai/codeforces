import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int r = sc.nextInt();
      int b = sc.nextInt();
      int d = sc.nextInt();

      System.out.println(solve(r, b, d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int r, int b, int d) {
    return (long) Math.min(r, b) * d >= Math.abs(r - b);
  }
}
