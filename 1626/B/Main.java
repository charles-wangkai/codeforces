import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String x = sc.next();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(String x) {
    for (int i = x.length() - 2; i >= 0; --i) {
      int sum = (x.charAt(i) - '0') + (x.charAt(i + 1) - '0');
      if (sum >= 10) {
        return String.format("%s%d%s", x.substring(0, i), sum, x.substring(i + 2));
      }
    }

    return String.format("%d%s", ((x.charAt(0) - '0') + (x.charAt(1) - '0')), x.substring(2));
  }
}
