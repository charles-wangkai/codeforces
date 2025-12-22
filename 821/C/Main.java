import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String[] commands = new String[2 * n];
    for (int i = 0; i < commands.length; ++i) {
      commands[i] = sc.nextLine();
    }

    System.out.println(solve(commands));

    sc.close();
  }

  static int solve(String[] commands) {
    int result = 0;
    int target = 1;
    Deque<Integer> stack = new ArrayDeque<>();
    for (String command : commands) {
      if (command.equals("remove")) {
        if (!stack.isEmpty() && stack.peek() != target) {
          stack.clear();
          ++result;
        } else if (!stack.isEmpty()) {
          stack.pop();
        }

        ++target;
      } else {
        int x = Integer.parseInt(command.split(" ")[1]);

        stack.push(x);
      }
    }

    return result;
  }
}