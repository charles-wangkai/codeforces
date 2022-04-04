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

  static String solve(String s) {
    int n = s.length();

    boolean[][] palindromes = new boolean[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j <= 1; ++j) {
        for (int beginIndex = i, endIndex = i + j;
            beginIndex >= 0 && endIndex < n && s.charAt(beginIndex) == s.charAt(endIndex);
            --beginIndex, ++endIndex) {
          palindromes[beginIndex][endIndex] = true;
        }
      }
    }

    int bestLeftLength = -1;
    int bestRightLength = -1;
    for (int leftLength = 0; leftLength <= n; ++leftLength) {
      for (int rightLength = 0; leftLength + rightLength <= n; ++rightLength) {
        if (rightLength <= leftLength
            && rightLength != 0
            && s.charAt(n - rightLength) != s.charAt(rightLength - 1)) {
          break;
        }

        int beginIndex;
        int endIndex;
        if (leftLength <= rightLength) {
          beginIndex = n - leftLength - (rightLength - leftLength);
          endIndex = n - leftLength - 1;
        } else {
          beginIndex = rightLength;
          endIndex = leftLength - 1;
        }

        if ((leftLength == rightLength || palindromes[beginIndex][endIndex])
            && leftLength + rightLength >= bestLeftLength + bestRightLength) {
          bestLeftLength = leftLength;
          bestRightLength = rightLength;
        }
      }
    }

    return String.format("%s%s", s.substring(0, bestLeftLength), s.substring(n - bestRightLength));
  }
}