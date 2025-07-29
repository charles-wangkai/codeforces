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
    if (n == 1) {
      return "a";
    }

    return (n % 2 == 0)
        ? "%sb%s".formatted("a".repeat(n / 2), "a".repeat(n / 2 - 1))
        : "%sbc%s".formatted("a".repeat(n / 2), "a".repeat(n / 2 - 1));
  }
}