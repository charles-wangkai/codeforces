import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n) {
    if (n == 0) {
      return true;
    }

    String s = Integer.toBinaryString(n);
    String trimmed = s.substring(0, s.lastIndexOf('1') + 1);

    for (int i = 0, j = trimmed.length() - 1; i <= j; ++i, --j) {
      if (trimmed.charAt(i) != trimmed.charAt(j) || (i == j && trimmed.charAt(i) == '1')) {
        return false;
      }
    }

    return true;
  }
}