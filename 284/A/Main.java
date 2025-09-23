import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int p = sc.nextInt();

    System.out.println(solve(p));

    sc.close();
  }

  static int solve(int p) {
    return (int) IntStream.range(1, p).filter(x -> isPrimitiveRoot(p, x)).count();
  }

  static boolean isPrimitiveRoot(int p, int x) {
    int power = 1;
    for (int i = 1; i <= p - 1; ++i) {
      power = multiplyMod(power, x, p);

      if ((power == 1) != (i == p - 1)) {
        return false;
      }
    }

    return true;
  }

  static int multiplyMod(int x, int y, int m) {
    return Math.floorMod(x * y, m);
  }
}