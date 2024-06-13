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
    int diff = s.chars().map(c -> (c == 'X') ? 1 : -1).sum();

    int minute = 0;
    StringBuilder changed = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == 'X') {
        if (diff > 0) {
          diff -= 2;
          ++minute;
          changed.append('x');
        } else {
          changed.append('X');
        }
      } else if (diff < 0) {
        diff += 2;
        ++minute;
        changed.append('X');
      } else {
        changed.append('x');
      }
    }

    return String.format("%d\n%s", minute, changed);
  }
}