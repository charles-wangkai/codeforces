import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(String s) {
    boolean[] printed = new boolean[s.length()];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      char command = s.charAt(i);
      if (command == '1') {
        stack.push(i);
      } else if (command == '2') {
        if (stack.isEmpty()) {
          printed[i] = true;
        } else {
          printed[stack.pop()] = true;
        }
      } else {
        printed[i] = true;
      }
    }

    int[] notPrinted = IntStream.range(0, printed.length).filter(i -> !printed[i]).toArray();

    return "%d\n%s"
        .formatted(
            notPrinted.length,
            Arrays.stream(notPrinted)
                .map(index -> index + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}