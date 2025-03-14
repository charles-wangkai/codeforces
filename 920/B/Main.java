import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int[] l, int[] r) {
    int[] result = new int[l.length];
    int index = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    int maxTime = Arrays.stream(r).max().getAsInt();
    for (int time = 1; time <= maxTime; ++time) {
      while (index != l.length && l[index] == time) {
        queue.offer(index);
        ++index;
      }

      while (!queue.isEmpty() && r[queue.peek()] < time) {
        queue.poll();
      }

      if (!queue.isEmpty()) {
        result[queue.poll()] = time;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}