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
    int c = 1;
    int a = (n - c) / 2;
    int b = n - a - c;
    while (a == b || (a % 2 == 0 && b % 2 == 0)) {
      --a;
      ++b;
    }

    return String.format("%d %d %d", a, b, c);
  }
}
