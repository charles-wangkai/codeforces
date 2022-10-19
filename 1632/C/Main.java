import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int a, int b) {
    int targetA = a;
    while ((targetA | b) != b) {
      ++targetA;
    }

    int targetB = b;
    while ((a | targetB) != targetB) {
      ++targetB;
    }

    return Math.min(targetA - a + ((targetA == b) ? 0 : 1), targetB - b + 1);
  }
}
