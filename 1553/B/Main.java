import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    for (int i = 0; i < t.length(); ++i) {
      for (int j = 0; j < s.length(); ++j) {
        if (check(s, j, t, i, -1) && check(s, j, t, i, 1)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean check(String s, int sIndex, String t, int tIndex, int tOffset) {
    while (tIndex >= 0 && tIndex < t.length()) {
      if (sIndex < 0 || sIndex >= s.length() || t.charAt(tIndex) != s.charAt(sIndex)) {
        return false;
      }

      --sIndex;
      tIndex += tOffset;
    }

    return true;
  }
}
