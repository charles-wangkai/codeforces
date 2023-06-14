import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        st = new StringTokenizer(br.readLine());
        a[i] = Integer.parseInt(st.nextToken());
        b[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, b));
    }
  }

  static long solve(int[] a, int[] b) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(
                Comparator.comparing((Integer i) -> a[i])
                    .thenComparing(Comparator.comparing((Integer i) -> b[i]).reversed()))
            .mapToInt(Integer::intValue)
            .toArray();

    long result = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    int index = 0;
    while (index != sortedIndices.length) {
      result += b[sortedIndices[index]];
      queue.offer(sortedIndices[index]);
      ++index;

      int x = queue.size();
      while (!queue.isEmpty() && a[queue.peek()] == x) {
        queue.poll();
      }
      while (index != sortedIndices.length && a[sortedIndices[index]] == x) {
        ++index;
      }
    }

    return result;
  }
}
