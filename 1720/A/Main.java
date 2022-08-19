import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int d = sc.nextInt();

      System.out.println(solve(a, b, c, d));
    }

    sc.close();
  }

  static int solve(int a, int b, int c, int d) {
    long product1 = (long) a * d;
    long product2 = (long) b * c;

    if (product1 == product2) {
      return 0;
    }
    if (product1 == 0 || product2 == 0 || product1 % product2 == 0 || product2 % product1 == 0) {
      return 1;
    }

    return 2;
  }
}