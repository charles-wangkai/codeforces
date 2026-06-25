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
    int[] counts = new int[26];
    for (char c : s.toCharArray()) {
      ++counts[c - 'a'];
    }

    StringBuilder result = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();
    int index = 0;
    for (int i = 0; i < counts.length; ++i) {
      char target = (char) ('a' + i);
      while (true) {
        if (!stack.isEmpty() && stack.peek() <= target) {
          result.append(stack.pop());
        } else if (counts[i] != 0) {
          char c = s.charAt(index);
          --counts[c - 'a'];
          ++index;

          stack.push(c);
        } else {
          break;
        }
      }
    }

    return result.toString();
  }
}