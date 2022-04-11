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
    int sIndex = s.length() - 1;
    int tIndex = t.length() - 1;
    while (sIndex >= 0) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        --sIndex;
        --tIndex;

        if (tIndex == -1) {
          return true;
        }
      } else {
        sIndex -= 2;
      }
    }

    return false;
  }
}