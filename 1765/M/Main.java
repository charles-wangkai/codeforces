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
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; ++i) {
      if (n % i == 0) {
        if (i == 1) {
          if (i * (n / i - 1) < b) {
            a = i;
            b = i * (n / i - 1);
          }
        } else if ((i - 1) * (n / i) < b) {
          a = n / i;
          b = (i - 1) * (n / i);
        }
      }
    }

    return String.format("%d %d", a, b);
  }
}
