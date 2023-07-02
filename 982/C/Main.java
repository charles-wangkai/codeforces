import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt() - 1;
      v[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(u, v));

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int n = u.length + 1;

    if (n % 2 == 1) {
      return -1;
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i]].add(v[i]);
      adjLists[v[i]].add(u[i]);
    }

    return search(adjLists, -1, 0).evenSizeCount() - 1;
  }

  static Outcome search(List<Integer>[] adjLists, int parent, int node) {
    int evenSizeCount = 0;
    int subtreeSize = 1;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        Outcome outcome = search(adjLists, node, adj);
        evenSizeCount += outcome.evenSizeCount();
        subtreeSize += outcome.subtreeSize();
      }
    }
    if (subtreeSize % 2 == 0) {
      ++evenSizeCount;
    }

    return new Outcome(evenSizeCount, subtreeSize);
  }
}

record Outcome(int evenSizeCount, int subtreeSize) {}
