import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  static final long LIMIT = (1L << 32) - 1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int l = sc.nextInt();
    sc.nextLine();
    String[] commands = new String[l];
    for (int i = 0; i < commands.length; i++) {
      commands[i] = sc.nextLine();
    }
    System.out.println(solve(commands));

    sc.close();
  }

  static String solve(String[] commands) {
    Deque<Element> stack = new ArrayDeque<>();
    stack.push(new Element(-1, 0));

    for (String command : commands) {
      if (command.startsWith("for")) {
        int loop = Integer.parseInt(command.split(" ")[1]);

        stack.push(new Element(loop, 0));
      } else if (command.equals("end")) {
        Element element = stack.pop();

        stack.peek().amount += element.loop * element.amount;
      } else {
        stack.peek().amount++;
      }

      if (stack.peek().amount > LIMIT) {
        return "OVERFLOW!!!";
      }
    }

    return String.valueOf(stack.peek().amount);
  }
}

class Element {
  int loop;
  long amount;

  Element(int loop, long amount) {
    this.loop = loop;
    this.amount = amount;
  }
}
