import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String x = sc.next();
      String s = sc.next();

      System.out.println(solve(x, s));
    }

    sc.close();
  }

  static int solve(String x, String s) {
    int result = 0;
    while (true) {
      if (x.contains(s)) {
        return result;
      }
      if (x.length() >= s.length() * 2 && result != 0) {
        return -1;
      }

      x = x + x;
      ++result;
    }
  }
}
