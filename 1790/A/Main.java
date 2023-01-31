import java.util.Scanner;

public class Main {
  static final String PI = "314159265358979323846264338327";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String n = sc.next();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(String n) {
    int result = 0;
    while (result != Math.min(n.length(), PI.length()) && n.charAt(result) == PI.charAt(result)) {
      ++result;
    }

    return result;
  }
}
