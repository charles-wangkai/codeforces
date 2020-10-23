import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int x) {
    String s = String.valueOf(x);

    return 10 * (s.charAt(0) - '0' - 1) + s.length() * (s.length() + 1) / 2;
  }
}
