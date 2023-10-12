import java.util.Scanner;

public class Main {
  static final int ITERATION_NUM = 100;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int Px = sc.nextInt();
      int Py = sc.nextInt();
      int Ax = sc.nextInt();
      int Ay = sc.nextInt();
      int Bx = sc.nextInt();
      int By = sc.nextInt();

      System.out.println(String.format("%.9f", solve(Px, Py, Ax, Ay, Bx, By)));
    }

    sc.close();
  }

  static double solve(int Px, int Py, int Ax, int Ay, int Bx, int By) {
    double result = -1;
    double lower = 0;
    double upper = 4000;
    for (int i = 0; i < ITERATION_NUM; ++i) {
      double middle = (lower + upper) / 2;
      if (check(Px, Py, Ax, Ay, Bx, By, middle)) {
        result = middle;
        upper = middle;
      } else {
        lower = middle;
      }
    }

    return result;
  }

  static boolean check(int Px, int Py, int Ax, int Ay, int Bx, int By, double w) {
    boolean aCoverO = computeDistance(Ax, Ay, 0, 0) <= w;
    boolean aCoverP = computeDistance(Ax, Ay, Px, Py) <= w;
    boolean bCoverO = computeDistance(Bx, By, 0, 0) <= w;
    boolean bCoverP = computeDistance(Bx, By, Px, Py) <= w;

    return (aCoverO && aCoverP)
        || (bCoverO && bCoverP)
        || ((aCoverO || bCoverO)
            && (aCoverP || bCoverP)
            && computeDistance(Ax, Ay, Bx, By) <= 2 * w);
  }

  static double computeDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  }
}
