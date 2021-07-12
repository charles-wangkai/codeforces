import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int xA = sc.nextInt();
      int yA = sc.nextInt();
      int xB = sc.nextInt();
      int yB = sc.nextInt();
      int xF = sc.nextInt();
      int yF = sc.nextInt();

      System.out.println(solve(xA, yA, xB, yB, xF, yF));
    }

    sc.close();
  }

  static int solve(int xA, int yA, int xB, int yB, int xF, int yF) {
    return Math.abs(xA - xB)
        + Math.abs(yA - yB)
        + (((xF == xA && xF == xB && yF >= Math.min(yA, yB) && yF <= Math.max(yA, yB))
                || (yF == yA && yF == yB && xF >= Math.min(xA, xB) && xF <= Math.max(xA, xB)))
            ? 2
            : 0);
  }
}
