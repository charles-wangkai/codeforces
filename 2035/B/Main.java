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
    if (n % 2 == 0) {
      return "3".repeat(n - 2) + "66";
    }
    if (n <= 3) {
      return "-1";
    }

    return "3".repeat(n - 5) + "36366";
  }
}