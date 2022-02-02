import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    @SuppressWarnings("unchecked")
    Queue<Integer>[] indexQueues = new Queue[a.length + 1];
    for (int i = 0; i < indexQueues.length; ++i) {
      indexQueues[i] = new ArrayDeque<>();
    }
    for (int i = 0; i < a.length; ++i) {
      indexQueues[a[i]].offer(i);
    }

    List<Integer> b = new ArrayList<>();
    int beginIndex = 0;
    int mex = indexQueues.length;
    while (beginIndex != a.length) {
      for (int i = mex - 1; i >= 0; --i) {
        while (!indexQueues[i].isEmpty() && indexQueues[i].peek() < beginIndex) {
          indexQueues[i].poll();
        }

        if (indexQueues[i].isEmpty()) {
          mex = i;
        }
      }

      b.add(mex);

      beginIndex =
          IntStream.range(0, mex).map(i -> indexQueues[i].peek()).max().orElse(beginIndex) + 1;
    }

    return String.format(
        "%d\n%s", b.size(), b.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}