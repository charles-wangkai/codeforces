import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    Boolean[] beginOrEnds = new Boolean[p.length];
    for (int i = 1; i <= p.length; ++i) {
      int index = valueToIndex.get(i);
      if (beginOrEnds[index] == null) {
        beginOrEnds[index] = true;

        ++index;
        while (index != beginOrEnds.length && beginOrEnds[index] == null) {
          beginOrEnds[index] = false;
          ++index;
        }
      }
    }

    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < p.length; ++i) {
      if (beginOrEnds[i]) {
        deque.offerFirst(p[i]);
      } else {
        deque.offerLast(p[i]);
      }
    }

    return deque.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}
