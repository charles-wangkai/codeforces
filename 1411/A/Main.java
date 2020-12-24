import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String S = sc.next();

      System.out.println(solve(S) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(String S) {
    int lastRightCount = 0;
    for (int i = S.length() - 1; i >= 0 && S.charAt(i) == ')'; --i) {
      ++lastRightCount;
    }

    return lastRightCount > S.length() - lastRightCount;
  }
}
