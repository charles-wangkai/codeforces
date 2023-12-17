import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int xk = sc.nextInt();
      int yk = sc.nextInt();
      int xq = sc.nextInt();
      int yq = sc.nextInt();

      System.out.println(solve(a, b, xk, yk, xq, yq));
    }

    sc.close();
  }

  static int solve(int a, int b, int xk, int yk, int xq, int yq) {
    return (int)
        Stream.of(
                new Offset(a, b),
                new Offset(a, -b),
                new Offset(-a, b),
                new Offset(-a, -b),
                new Offset(b, a),
                new Offset(b, -a),
                new Offset(-b, a),
                new Offset(-b, -a))
            .distinct()
            .filter(offset -> canAttack(a, b, xk + offset.x(), yk + offset.y(), xq, yq))
            .count();
  }

  static boolean canAttack(int a, int b, int x1, int y1, int x2, int y2) {
    int xDelta = Math.abs(x1 - x2);
    int yDelta = Math.abs(y1 - y2);

    return (xDelta == a && yDelta == b) || (xDelta == b && yDelta == a);
  }
}

record Offset(int x, int y) {}
