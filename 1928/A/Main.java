import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int a, int b) {
    return (a % 2 == 0 && !isSame(a, b, a / 2, b * 2))
        || (b % 2 == 0 && !isSame(a, b, a * 2, b / 2));
  }

  static boolean isSame(int a1, int b1, int a2, int b2) {
    return Math.min(a1, b1) == Math.min(a2, b2) && Math.max(a1, b1) == Math.max(a2, b2);
  }
}