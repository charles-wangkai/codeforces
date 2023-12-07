import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    Deque<Integer> lowerIndices = new ArrayDeque<>();
    Deque<Integer> upperIndices = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (Character.isLowerCase(c)) {
        if (c == 'b') {
          lowerIndices.pollLast();
        } else {
          lowerIndices.offerLast(i);
        }
      } else if (c == 'B') {
        upperIndices.pollLast();
      } else {
        upperIndices.offerLast(i);
      }
    }

    StringBuilder result = new StringBuilder();
    while (!lowerIndices.isEmpty() || !upperIndices.isEmpty()) {
      if (!lowerIndices.isEmpty()
          && (upperIndices.isEmpty() || lowerIndices.peekFirst() < upperIndices.peekFirst())) {
        result.append(s.charAt(lowerIndices.pollFirst()));
      } else {
        result.append(s.charAt(upperIndices.pollFirst()));
      }
    }

    return result.toString();
  }
}