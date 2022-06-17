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

  static String solve(int a, int b) {
    return String.format(
        "%s%s%s",
        "01".repeat(Math.min(a, b)),
        "0".repeat(Math.max(0, a - b)),
        "1".repeat(Math.max(0, b - a)));
  }
}