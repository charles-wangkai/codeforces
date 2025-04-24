import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int t = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int da = sc.nextInt();
    int db = sc.nextInt();

    System.out.println(solve(x, t, a, b, da, db) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int x, int t, int a, int b, int da, int db) {
    for (int i = 0; i <= t; ++i) {
      for (int j = 0; j <= t; ++j) {
        if (((i == t) ? 0 : (a - i * da)) + ((j == t) ? 0 : (b - j * db)) == x) {
          return true;
        }
      }
    }

    return false;
  }
}