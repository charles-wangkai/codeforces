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
    int moveNum = 0;
    Deque<Character> stack = new ArrayDeque<>();
    for (char letter : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == letter) {
        stack.pop();

        moveNum++;
      } else {
        stack.push(letter);
      }
    }
    return moveNum % 2 != 0;
  }
}
