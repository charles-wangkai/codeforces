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
    int rowDistance = Math.abs(a);
    int colDistance = Math.abs(b);

    return (rowDistance == colDistance)
        ? (2 * rowDistance)
        : (2 * Math.max(rowDistance, colDistance) - 1);
  }
}
