import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt() - 1;
        v[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(u, v, k));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v, int k) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[n];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjSets[u[i]].add(v[i]);
      adjSets[v[i]].add(u[i]);
    }

    boolean[] removed = new boolean[n];
    Set<Integer> leaves =
        IntStream.range(0, adjSets.length)
            .filter(i -> adjSets[i].size() <= 1)
            .boxed()
            .collect(Collectors.toSet());
    for (int i = 0; i < k && !leaves.isEmpty(); ++i) {
      Set<Integer> nextLeaves = new HashSet<>();
      for (int leaf : leaves) {
        removed[leaf] = true;
      }
      for (int leaf : leaves) {
        for (int adj : adjSets[leaf]) {
          adjSets[adj].remove(leaf);

          if (!removed[adj] && adjSets[adj].size() <= 1) {
            nextLeaves.add(adj);
          }
        }
      }

      leaves = nextLeaves;
    }

    return (int) IntStream.range(0, removed.length).filter(i -> !removed[i]).count();
  }
}
