import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n) {
    for (int i = 0; i * 2020 <= n; ++i) {
      if ((n - i * 2020) % 2021 == 0) {
        return true;
      }
    }

    return false;
  }
}
