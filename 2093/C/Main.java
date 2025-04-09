import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(x, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int x, int k) {
    if (x != 1 && k >= 2) {
      return false;
    }

    int value = Integer.parseInt(String.valueOf(x).repeat(k));
    if (value <= 1) {
      return false;
    }

    for (int i = 2; i * i <= value; ++i) {
      if (value % i == 0) {
        return false;
      }
    }

    return true;
  }
}