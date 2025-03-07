import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] q = new int[n];
      for (int i = 0; i < q.length; ++i) {
        q[i] = sc.nextInt();
      }

      System.out.println(solve(q));
    }

    sc.close();
  }

  static String solve(int[] q) {
    List<Integer> result = new ArrayList<>();
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int qi : q) {
      if (qi == max) {
        if (stack.isEmpty()) {
          return "-1";
        }

        result.add(stack.pop());
      } else {
        for (int i = max + 1; i < qi; ++i) {
          stack.push(i);
        }
        max = qi;

        result.add(qi);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}