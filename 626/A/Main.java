import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String commands = sc.next();

    System.out.println(solve(commands));

    sc.close();
  }

  static int solve(String commands) {
    int result = 0;
    int r = 0;
    int c = 0;
    Map<Point, Integer> pointToCount = new HashMap<>();
    pointToCount.put(new Point(0, 0), 1);
    for (char command : commands.toCharArray()) {
      if (command == 'U') {
        --r;
      } else if (command == 'R') {
        ++c;
      } else if (command == 'D') {
        ++r;
      } else {
        --c;
      }

      Point point = new Point(r, c);
      result += pointToCount.getOrDefault(point, 0);
      pointToCount.put(point, pointToCount.getOrDefault(point, 0) + 1);
    }

    return result;
  }
}

record Point(int r, int c) {}
