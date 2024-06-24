import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int d = sc.nextInt();
    int h = sc.nextInt();
    int v = sc.nextInt();
    int e = sc.nextInt();

    System.out.println(solve(d, h, v, e));

    sc.close();
  }

  static String solve(int d, int h, int v, int e) {
    double delta = v - Math.PI * d * d / 4 * e;

    return (delta > 0) ? String.format("YES\n%.9f", Math.PI * d * d / 4 * h / delta) : "NO";
  }
}