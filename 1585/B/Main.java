import java.util.Scanner;
import java.util.Stack;

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

  static int solve(int[] a) {
    int lastMaxIndex = 0;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] >= a[lastMaxIndex]) {
        lastMaxIndex = i;
      }
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = lastMaxIndex + 1; i < a.length; ++i) {
      while (!stack.empty() && a[i] >= stack.peek()) {
        stack.pop();
      }

      stack.push(a[i]);
    }

    return stack.size();
  }
}
