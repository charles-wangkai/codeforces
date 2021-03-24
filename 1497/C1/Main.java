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

  static String solve(int n, int k) {
    int a1;
    int a2;
    int a3;
    if (n % 2 != 0) {
      a1 = 1;
      a2 = (n - 1) / 2;
      a3 = (n - 1) / 2;
    } else if (n % 4 == 0) {
      a1 = n / 2;
      a2 = n / 4;
      a3 = n / 4;
    } else {
      a1 = 2;
      a2 = (n - 2) / 2;
      a3 = (n - 2) / 2;
    }

    return String.format("%d %d %d", a1, a2, a3);
  }
}
