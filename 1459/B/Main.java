import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    int half = n / 2;

    int result = 0;
    for (int x = -n; x <= n; ++x) {
      for (int y = -n; y <= n; ++y) {
        if (check(Math.abs(x), half, Math.abs(y), n - half)
            || check(Math.abs(y), half, Math.abs(x), n - half)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean check(int side1, int maxSide1, int side2, int maxSide2) {
    return side1 <= maxSide1
        && (maxSide1 - side1) % 2 == 0
        && side2 <= maxSide2
        && (maxSide2 - side2) % 2 == 0;
  }
}
