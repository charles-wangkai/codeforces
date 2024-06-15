import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<String> commands = new ArrayList<>();
    while (sc.hasNextLine()) {
      String command = sc.nextLine();
      commands.add(command);
    }

    System.out.println(solve(commands));

    sc.close();
  }

  static int solve(List<String> commands) {
    int result = 0;
    int count = 0;
    for (String command : commands) {
      if (command.startsWith("+")) {
        ++count;
      } else if (command.startsWith("-")) {
        --count;
      } else {
        result += count * (command.length() - command.indexOf(':') - 1);
      }
    }

    return result;
  }
}