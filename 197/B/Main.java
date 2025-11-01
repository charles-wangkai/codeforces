import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m + 1];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    if (a.length > b.length) {
      return "%sInfinity".formatted((Integer.signum(a[0]) == Integer.signum(b[0])) ? "" : "-");
    }
    if (a.length < b.length) {
      return "0/1";
    }

    int g = gcd(a[0], b[0]);
    int p = a[0] / g;
    int q = b[0] / g;
    if (q < 0) {
      p *= -1;
      q *= -1;
    }

    return "%d/%d".formatted(p, q);
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
