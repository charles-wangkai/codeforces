import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static int solve(int l, int r) {
    return (l == 1) ? Math.max(1, r - 1) : (r - l);
  }
}