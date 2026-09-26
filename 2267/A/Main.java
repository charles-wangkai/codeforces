import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      char c = sc.next().charAt(0);
      String s = sc.next();

      System.out.println(solve(s, c));
    }

    sc.close();
  }

  static int solve(String s, char c) {
    int result = 0;
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
      if (s.charAt(i) != s.charAt(j)) {
        result += ((s.charAt(i) == c) ? 0 : 1) + ((s.charAt(j) == c) ? 0 : 1);
      }
    }

    return result;
  }
}