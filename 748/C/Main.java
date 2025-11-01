import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String movements = sc.next();

    System.out.println(solve(movements));

    sc.close();
  }

  static int solve(String movements) {
    int result = 0;
    Set<Character> seen = new HashSet<>();
    seen.add('L');
    seen.add('R');
    seen.add('U');
    seen.add('D');
    for (char movement : movements.toCharArray()) {
      if (movement == 'L') {
        if (seen.contains('R')) {
          ++result;
          seen.clear();
        }
      } else if (movement == 'R') {
        if (seen.contains('L')) {
          ++result;
          seen.clear();
        }
      } else if (movement == 'U') {
        if (seen.contains('D')) {
          ++result;
          seen.clear();
        }
      } else if (seen.contains('U')) {
        ++result;
        seen.clear();
      }

      seen.add(movement);
    }

    return result;
  }
}