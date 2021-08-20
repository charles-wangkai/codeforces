import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int W = sc.nextInt();
      int H = sc.nextInt();
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();
      int w = sc.nextInt();
      int h = sc.nextInt();

      System.out.println(String.format("%.9f", solve(W, H, x1, y1, x2, y2, w, h)));
    }

    sc.close();
  }

  static double solve(int W, int H, int x1, int y1, int x2, int y2, int w, int h) {
    int dw =
        (x2 - x1 + w > W)
            ? Integer.MAX_VALUE
            : Math.min(Math.max(0, w - x1), Math.max(0, w - (W - x2)));
    int dh =
        (y2 - y1 + h > H)
            ? Integer.MAX_VALUE
            : Math.min(Math.max(0, h - y1), Math.max(0, h - (H - y2)));
    int result = Math.min(dw, dh);

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }
}
