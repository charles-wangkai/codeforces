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
    int leftIndex = 0;
    int rightIndex = s.length() - 1;
    char target = (char) ('a' + s.length() - 1);
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(leftIndex) == target) {
        ++leftIndex;
      } else if (s.charAt(rightIndex) == target) {
        --rightIndex;
      } else {
        return false;
      }

      --target;
    }

    return true;
  }
}
