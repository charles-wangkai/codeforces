import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int a, int b, int c) {
    return String.format(
        "%d %d %d",
        Math.max(0, Math.max(b, c) + 1 - a),
        Math.max(0, Math.max(c, a) + 1 - b),
        Math.max(0, Math.max(a, b) + 1 - c));
  }
}
