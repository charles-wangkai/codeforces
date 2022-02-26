import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(String s) {
    int result = Integer.MAX_VALUE;
    for (char c = 'a'; c <= 'z'; ++c) {
      char c_ = c;
      int[] restIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) != c_).toArray();
      if (isPalindrome(s, restIndices)) {
        int[] indices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == c_).toArray();
        if (restIndices.length == 0) {
          return 0;
        } else {
          int leftIndex = restIndices[(restIndices.length - 1) / 2];
          int rightIndex = restIndices[restIndices.length - 1 - (restIndices.length - 1) / 2];
          int eraseCount = 0;
          while (leftIndex != -1 || rightIndex != s.length()) {
            if (leftIndex == -1) {
              ++rightIndex;
              ++eraseCount;
            } else if (rightIndex == s.length()) {
              --leftIndex;
              ++eraseCount;
            } else if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
              --leftIndex;
              ++rightIndex;
            } else if (s.charAt(leftIndex) == c) {
              --leftIndex;
              ++eraseCount;
            } else {
              ++rightIndex;
              ++eraseCount;
            }
          }

          result = Math.min(result, eraseCount);
        }
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  static boolean isPalindrome(String s, int[] restIndices) {
    for (int i = 0, j = restIndices.length - 1; i < j; ++i, --j) {
      if (s.charAt(restIndices[i]) != s.charAt(restIndices[j])) {
        return false;
      }
    }

    return true;
  }
}