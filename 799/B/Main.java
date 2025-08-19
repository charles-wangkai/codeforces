import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] c = new int[m];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    System.out.println(solve(p, a, b, c));

    sc.close();
  }

  static String solve(int[] p, int[] a, int[] b, int[] c) {
    Map<Integer, PriorityQueue<Integer>> colorToSortedIndices = new HashMap<>();
    for (int i = 0; i < p.length; ++i) {
      for (int color : new int[] {a[i], b[i]}) {
        colorToSortedIndices.putIfAbsent(
            color, new PriorityQueue<>(Comparator.comparing(index -> p[index])));
        colorToSortedIndices.get(color).offer(i);
      }
    }

    int[] result = new int[c.length];
    Arrays.fill(result, -1);

    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < result.length; ++i) {
      if (colorToSortedIndices.containsKey(c[i])) {
        PriorityQueue<Integer> sortedIndices = colorToSortedIndices.get(c[i]);
        while (!sortedIndices.isEmpty() && seen.contains(sortedIndices.peek())) {
          sortedIndices.poll();
        }

        if (!sortedIndices.isEmpty()) {
          int index = sortedIndices.poll();
          result[i] = p[index];
          seen.add(index);
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}