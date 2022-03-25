import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int operationNum = 0;
    int beginIndex = 0;
    int depth = 0;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == '(') {
        ++depth;
      } else {
        --depth;
      }

      if ((depth == 0 && s.charAt(beginIndex) == '(')
          || (s.startsWith(")(", beginIndex) && c == ')' && i != beginIndex)
          || (i == beginIndex + 1 && s.charAt(i) == s.charAt(beginIndex))) {
        ++operationNum;
        beginIndex = i + 1;
        depth = 0;
      }
    }

    return String.format("%d %d", operationNum, s.length() - beginIndex);
  }
}