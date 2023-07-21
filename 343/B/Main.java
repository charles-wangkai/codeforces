import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    System.out.println(solve(s) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
      if (!stack.isEmpty() && ch == stack.peek()) {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }

    return stack.isEmpty();
  }
}
