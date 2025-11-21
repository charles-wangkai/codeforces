import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    System.out.println(solve(s, t));

    sc.close();
  }

  static int solve(String s, String t) {
    int leftIndex = findLeftIndex(s, t);

    return (leftIndex == -1) ? 0 : Math.max(0, findRightIndex(s, t) - leftIndex);
  }

  static int findLeftIndex(String s, String t) {
    int sIndex = 0;
    for (int i = 0; i < t.length(); ++i) {
      if (t.charAt(i) == s.charAt(sIndex)) {
        ++sIndex;

        if (sIndex == s.length()) {
          return i;
        }
      }
    }

    return -1;
  }

  static int findRightIndex(String s, String t) {
    int sIndex = s.length() - 1;
    for (int i = t.length() - 1; ; --i) {
      if (t.charAt(i) == s.charAt(sIndex)) {
        --sIndex;

        if (sIndex == -1) {
          return i;
        }
      }
    }
  }
}