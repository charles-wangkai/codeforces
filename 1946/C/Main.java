import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] v = new int[n - 1];
      int[] u = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        v[i] = sc.nextInt();
        u[i] = sc.nextInt();
      }

      System.out.println(solve(v, u, k));
    }

    sc.close();
  }

  static int solve(int[] v, int[] u, int k) {
    int n = v.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < v.length; ++i) {
      adjLists[v[i] - 1].add(u[i] - 1);
      adjLists[u[i] - 1].add(v[i] - 1);
    }

    int result = -1;
    int lower = 1;
    int upper = n;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(k, adjLists, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int k, List<Integer>[] adjLists, int minSize) {
    return search(k, adjLists, minSize, -1, 0).componentCount() >= k + 1;
  }

  static Outcome search(int k, List<Integer>[] adjLists, int minSize, int parent, int node) {
    int componentCount = 0;
    int size = 1;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        Outcome outcome = search(k, adjLists, minSize, node, adj);
        componentCount += outcome.componentCount();
        size += outcome.size();
      }
    }

    if (size >= minSize) {
      ++componentCount;
      size = 0;
    }

    return new Outcome(componentCount, size);
  }
}

record Outcome(int componentCount, int size) {}
