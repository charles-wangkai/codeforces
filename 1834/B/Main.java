import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String L = sc.next();
      String R = sc.next();

      System.out.println(solve(L, R));
    }

    sc.close();
  }

  static int solve(String L, String R) {
    int maxLength = Math.max(L.length(), R.length());

    L = "0".repeat(maxLength - L.length()) + L;
    R = "0".repeat(maxLength - R.length()) + R;

    int result = 0;
    boolean seenDiff = false;
    for (int i = 0; i < maxLength; ++i) {
      if (seenDiff) {
        result += 9;
      } else if (L.charAt(i) != R.charAt(i)) {
        result += Math.abs(L.charAt(i) - R.charAt(i));
        seenDiff = true;
      }
    }

    return result;
  }
}
