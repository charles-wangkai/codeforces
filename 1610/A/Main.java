import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static int solve(int n, int m) {
    if (n == 1 && m == 1) {
      return 0;
    } else if (n == 1 || m == 1) {
      return 1;
    }

    return 2;
  }
}
