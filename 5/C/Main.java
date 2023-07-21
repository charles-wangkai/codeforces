import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int maxLength = 0;
    int count = 1;
    Deque<Integer> stack = new ArrayDeque<>();
    int nextBeginIndex = -1;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') {
        if (nextBeginIndex == -1) {
          stack.push(i);
        } else {
          stack.push(nextBeginIndex);
          nextBeginIndex = -1;
        }
      } else if (stack.isEmpty()) {
        nextBeginIndex = -1;
      } else {
        int beginIndex = stack.pop();
        int length = i - beginIndex + 1;
        if (length > maxLength) {
          maxLength = length;
          count = 1;
        } else if (length == maxLength) {
          ++count;
        }

        nextBeginIndex = beginIndex;
      }
    }

    return String.format("%d %d", maxLength, count);
  }
}
