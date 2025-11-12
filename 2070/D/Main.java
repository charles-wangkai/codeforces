import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 998_244_353;

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
    int n = p.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      childLists[p[i] - 1].add(i + 1);
    }

    int[] depths = new int[n];

    int[] wayNums = new int[n];
    wayNums[0] = 1;

    List<Integer> depthWayNumSums = new ArrayList<>();
    depthWayNumSums.add(1);

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);

    while (!queue.isEmpty()) {
      int head = queue.poll();

      if (head != 0) {
        int parent = p[head - 1] - 1;
        wayNums[head] =
            addMod(depthWayNumSums.get(depths[head] - 1), (parent == 0) ? 0 : -wayNums[parent]);

        if (depths[head] == depthWayNumSums.size()) {
          depthWayNumSums.add(0);
        }
        depthWayNumSums.set(depths[head], addMod(depthWayNumSums.get(depths[head]), wayNums[head]));
      }

      for (int child : childLists[head]) {
        depths[child] = depths[head] + 1;
        queue.offer(child);
      }
    }

    return Arrays.stream(wayNums).reduce(Main::addMod).getAsInt();
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}