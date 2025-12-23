import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int depthThreshold = computeMaxDepth(s) / 2;

    char[] result = new char[s.length()];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else if (stack.size() <= depthThreshold) {
        result[stack.pop()] = '0';
        result[i] = '0';
      } else {
        result[stack.pop()] = '1';
        result[i] = '1';
      }
    }

    return String.valueOf(result);
  }

  static int computeMaxDepth(String s) {
    int result = 0;
    int depth = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        ++depth;
        result = Math.max(result, depth);
      } else {
        --depth;
      }
    }

    return result;
  }
}