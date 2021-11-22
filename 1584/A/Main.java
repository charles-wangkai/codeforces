import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static String solve(int u, int v) {
    return String.format("%d %d", (long) u * u, -(long) v * v);
  }
}
