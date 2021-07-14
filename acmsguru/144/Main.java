import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    double Z = sc.nextDouble();

    System.out.println(String.format("%.7f", solve(X, Y, Z)));

    sc.close();
  }

  static double solve(int X, int Y, double Z) {
    double p = Z / (60.0 * (Y - X));

    return 1 - (1 - p) * (1 - p);
  }
}
