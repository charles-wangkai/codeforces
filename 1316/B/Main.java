import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    String smallest = s;
    int k = 1;
    for (int i = 2; i <= s.length(); ++i) {
      String prefix = s.substring(0, i - 1);
      String r =
          String.format(
              "%s%s",
              s.substring(i - 1),
              ((s.length() - i) % 2 == 0)
                  ? new StringBuilder(prefix).reverse().toString()
                  : prefix);
      if (r.compareTo(smallest) < 0) {
        smallest = r;
        k = i;
      }
    }

    return String.format("%s\n%d", smallest, k);
  }
}