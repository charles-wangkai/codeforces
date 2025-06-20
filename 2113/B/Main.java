import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int w = sc.nextInt();
      int h = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      System.out.println(solve(w, h, a, b, x1, y1, x2, y2) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int w, int h, int a, int b, int x1, int y1, int x2, int y2) {
    return (x1 + a <= x2 && (x2 - x1) % a == 0)
        || (x2 + a <= x1 && (x1 - x2) % a == 0)
        || (y1 + b <= y2 && (y2 - y1) % b == 0)
        || (y2 + b <= y1 && (y1 - y2) % b == 0);
  }
}