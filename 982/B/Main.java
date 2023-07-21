import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < w.length; i++) {
      w[i] = sc.nextInt();
    }
    String s = sc.next();
    System.out.println(solve(w, s));

    sc.close();
  }

  static String solve(int[] w, String s) {
    int[] indices =
        IntStream.range(0, w.length)
            .boxed()
            .sorted((index1, index2) -> Integer.compare(w[index1], w[index2]))
            .mapToInt(x -> x)
            .toArray();

    List<Integer> result = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    int idx = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '0') {
        stack.push(indices[idx] + 1);
        idx++;

        result.add(stack.peek());
      } else {
        result.add(stack.pop());
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}
