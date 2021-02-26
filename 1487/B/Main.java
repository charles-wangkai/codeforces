import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    if (n % 2 == 0) {
      return (k - 1) % n + 1;
    }

    int index = (k - 1) % n;
    int a = n - 1;
    int b = ((k - 1) / n * 2) % (n - 1);
    int step = (a - b) / 2;
    if (index < step) {
      return b + index + 1;
    }

    index -= step;
    a -= step;
    b = (b + step + 1) % n;
    step = n / 2;
    if (index < step) {
      return (b + index) % n + 1;
    }

    index -= step;
    a = (a - step + n) % n;
    b = (b + step + 1) % n;

    return (b + index) % n + 1;
  }
}
