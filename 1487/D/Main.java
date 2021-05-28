import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int root = (int) Math.round(Math.sqrt(2 * n - 1));
    if (root * root > 2 * n - 1) {
      --root;
    }

    return (root - 1) / 2;
  }
}
