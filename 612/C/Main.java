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
    int replaceCount = 0;
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '<' || c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return "Impossible";
        }

        char top = stack.pop();
        if ((top == '<' && c != '>')
            || (top == '{' && c != '}')
            || (top == '[' && c != ']')
            || (top == '(' && c != ')')) {
          ++replaceCount;
        }
      }
    }

    return stack.isEmpty() ? String.valueOf(replaceCount) : "Impossible";
  }
}