import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int pi : p) {
      if (stack.isEmpty() || stack.peek() > pi) {
        stack.push(pi);
      } else {
        int min = stack.pop();

        while (!stack.isEmpty() && stack.peek() < pi) {
          stack.pop();
        }

        stack.push(min);
      }
    }

    return (stack.size() == 1) ? "Yes" : "No";
  }
}