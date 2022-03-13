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
    if (n % 3 == 0) {
      return "21".repeat(n / 3);
    } else if (n % 3 == 1) {
      return String.format("1%s", "21".repeat(n / 3));
    }

    return String.format("%s2", "21".repeat(n / 3));
  }
}