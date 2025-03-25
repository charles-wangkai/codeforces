import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int q = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }
    int[] types = new int[q];
    int[] ids = new int[q];
    for (int i = 0; i < q; ++i) {
      types[i] = sc.nextInt();
      ids[i] = sc.nextInt();
    }

    System.out.println(solve(t, k, types, ids));

    sc.close();
  }

  static String solve(int[] t, int k, int[] types, int[] ids) {
    List<String> result = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> t[i]));
    Set<Integer> displayed = new HashSet<>();
    for (int i = 0; i < types.length; ++i) {
      if (types[i] == 1) {
        pq.offer(ids[i] - 1);
        displayed.add(ids[i] - 1);

        if (pq.size() == k + 1) {
          displayed.remove(pq.poll());
        }
      } else {
        result.add(displayed.contains(ids[i] - 1) ? "YES" : "NO");
      }
    }

    return String.join("\n", result);
  }
}