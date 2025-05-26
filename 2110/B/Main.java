import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    return !isBalanced(s.substring(1, s.length() - 1));
  }

  static boolean isBalanced(String str) {
    int depth = 0;
    for (char c : str.toCharArray()) {
      depth += (c == '(') ? 1 : -1;
      if (depth == -1) {
        return false;
      }
    }

    return depth == 0;
  }
}