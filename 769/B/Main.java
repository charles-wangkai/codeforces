import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int[] sortedIndices =
        IntStream.range(1, a.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> a[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();
    int pos = 0;

    List<String> messages = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);
    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int i = 0; i < a[head]; ++i) {
        if (pos != sortedIndices.length) {
          messages.add("%d %d".formatted(head + 1, sortedIndices[pos] + 1));
          queue.offer(sortedIndices[pos]);
          ++pos;
        }
      }
    }

    return (pos == sortedIndices.length)
        ? "%d\n%s".formatted(messages.size(), String.join("\n", messages))
        : "-1";
  }
}