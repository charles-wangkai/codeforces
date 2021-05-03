import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n) {
    return (n % 2 == 0 && isSquare(n / 2)) || (n % 4 == 0 && isSquare(n / 4));
  }

  static boolean isSquare(int x) {
    int root = (int) Math.round(Math.sqrt(x));

    return root * root == x;
  }
}
