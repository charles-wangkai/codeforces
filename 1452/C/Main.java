import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int result = 0;
    int curveCount = 0;
    int squareCount = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        ++curveCount;
      } else if (ch == ')') {
        if (curveCount != 0) {
          ++result;
          --curveCount;
        }
      } else if (ch == '[') {
        ++squareCount;
      } else {
        if (squareCount != 0) {
          ++result;
          --squareCount;
        }
      }
    }

    return result;
  }
}
