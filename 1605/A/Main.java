import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int a3 = sc.nextInt();

      System.out.println(solve(a1, a2, a3));
    }

    sc.close();
  }

  static int solve(int a1, int a2, int a3) {
    return (Math.abs(a1 + a3 - 2 * a2) % 3 == 0) ? 0 : 1;
  }
}
