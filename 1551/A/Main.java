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

  static String solve(int n) {
    int c1;
    int c2;
    if (n % 3 == 0) {
      c1 = n / 3;
      c2 = n / 3;
    } else if (n % 3 == 1) {
      c1 = n / 3 + 1;
      c2 = n / 3;
    } else {
      c1 = n / 3;
      c2 = n / 3 + 1;
    }

    return String.format("%d %d", c1, c2);
  }
}
