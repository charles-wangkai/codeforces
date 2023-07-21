import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    List<String> result = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int ai : a) {
      if (ai != 1) {
        while (stack.peek() + 1 != ai) {
          stack.pop();
        }

        stack.pop();
      }
      stack.push(ai);

      List<Integer> reversed = new ArrayList<>(stack);
      Collections.reverse(reversed);

      result.add(reversed.stream().map(String::valueOf).collect(Collectors.joining(".")));
    }

    return String.join("\n", result);
  }
}
