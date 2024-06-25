import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      System.out.println(solve(x1, y1, x2, y2) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int x1, int y1, int x2, int y2) {
    return (x1 < y1) == (x2 < y2);
  }
}