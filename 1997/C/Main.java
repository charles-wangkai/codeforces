import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static long solve(String s) {
    long result = 0;
    int depth = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      char c;
      if (i % 2 == 0) {
        if (depth == 0) {
          c = '(';
        } else {
          c = ')';
        }
      } else {
        c = s.charAt(i);
      }

      if (c == '(') {
        ++depth;
        stack.push(i);
      } else {
        --depth;
        result += i - stack.pop();
      }
    }

    return result;
  }
}