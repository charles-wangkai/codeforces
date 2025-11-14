import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt();
    int t1 = sc.nextInt();
    int t2 = sc.nextInt();

    System.out.println(solve(h, m, s, t1, t2) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int h, int m, int s, int t1, int t2) {
    int angle1 = t1 % 12 * 30;
    int angle2 = t2 % 12 * 30;

    int minAngle = Math.min(angle1, angle2);
    int maxAngle = Math.max(angle1, angle2);

    boolean canIn = true;
    boolean canOut = true;
    for (double angle :
        new double[] {s * 6, m * 6 + s / 60.0 * 6, h % 12 * 30 + (m * 60 + s) / 3600.0 * 30}) {
      if (angle > minAngle && angle < maxAngle) {
        canIn = false;
      } else {
        canOut = false;
      }
    }

    return canIn || canOut;
  }
}