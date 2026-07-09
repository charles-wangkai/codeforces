import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n - 1];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    Map<Integer, Integer> parentToCount = new HashMap<>();
    parentToCount.put(-1, 1);
    for (int pi : p) {
      parentToCount.put(pi, parentToCount.getOrDefault(pi, 0) + 1);
    }

    int[] sortedCounts =
        parentToCount.values().stream()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = 0;
    int index = 0;
    PriorityQueue<Integer> rests = new PriorityQueue<>(Comparator.reverseOrder());
    while (index != sortedCounts.length || !rests.isEmpty()) {
      PriorityQueue<Integer> nextRests = new PriorityQueue<>(Comparator.reverseOrder());
      while (!rests.isEmpty()) {
        int rest = rests.poll();
        if (rest != 1) {
          nextRests.add(rest - 1);
        }
      }

      rests = nextRests;

      if (index == sortedCounts.length) {
        if (!rests.isEmpty()) {
          int rest = rests.poll();
          if (rest != 1) {
            rests.offer(rest - 1);
          }
        }
      } else {
        int rest = sortedCounts[index] - 1;
        ++index;

        if (rest != 0) {
          rests.offer(rest);
        }
      }

      ++result;
    }

    return result;
  }
}