import java.util.Scanner;

public class Main {
  static String f;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static void precompute() {
    f = "";
    for (int i = 1; i <= 45; ++i) {
      if (i % 3 == 0) {
        f += 'F';
      }
      if (i % 5 == 0) {
        f += 'B';
      }
    }
  }

  static boolean solve(String s) {
    return f.contains(s);
  }
}
