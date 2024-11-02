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
    if (n == 1) {
      return "1\n1";
    }
    if (k == 1 || k == n) {
      return "-1";
    }

    int p2;
    int p3;
    if ((k - 1) % 2 == 1) {
      p2 = k;
      p3 = k + 1;
    } else {
      p2 = k - 1;
      p3 = k + 2;
    }

    return "3\n1 %d %d".formatted(p2, p3);
  }
}