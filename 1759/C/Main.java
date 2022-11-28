import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int x = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(l, r, x, a, b));
    }

    sc.close();
  }

  static int solve(int l, int r, int x, int a, int b) {
    if (a == b) {
      return 0;
    }
    if (isValid(x, a, b)) {
      return 1;
    }
    if ((isValid(x, a, l) && isValid(x, l, b)) || (isValid(x, a, r) && isValid(x, r, b))) {
      return 2;
    }
    if ((isValid(x, a, l) && isValid(x, l, r) && isValid(x, r, b))
        || (isValid(x, a, r) && isValid(x, r, l) && isValid(x, l, b))) {
      return 3;
    }

    return -1;
  }

  static boolean isValid(int x, int from, int to) {
    return Math.abs(to - from) >= x;
  }
}
