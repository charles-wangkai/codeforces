import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int n, int m) {
    return n >= m && n % 2 == m % 2;
  }
}