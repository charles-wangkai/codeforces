import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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
    List<String> edges = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int pi : p) {
      if (stack.isEmpty() || stack.peek() > pi) {
        stack.push(pi);
      } else {
        int min = stack.pop();
        edges.add("%d %d".formatted(min, pi));

        while (!stack.isEmpty() && stack.peek() < pi) {
          edges.add("%d %d".formatted(stack.pop(), pi));
        }

        stack.push(min);
      }
    }

    return (stack.size() == 1) ? "Yes\n%s".formatted(String.join("\n", edges)) : "No";
  }
}