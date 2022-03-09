import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int a = sc.nextInt();

      System.out.println(solve(l, r, a));
    }

    sc.close();
  }

  static int solve(int l, int r, int a) {
    int result = r / a + r % a;

    int x = (r / a - 1) * a + a - 1;
    if (x >= l) {
      result = Math.max(result, x / a + x % a);
    }

    return result;
  }
}