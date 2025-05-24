import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }
      int[] x = new int[n - 1];
      int[] y = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(p, h, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] p, int[] h, int[] x, int[] y) {
    int n = p.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < x.length; ++i) {
      adjLists[x[i] - 1].add(y[i] - 1);
      adjLists[y[i] - 1].add(x[i] - 1);
    }

    return search(p, h, adjLists, -1, 0).badNum() != -1;
  }

  static Outcome search(int[] p, int[] h, List<Integer>[] adjLists, int parent, int node) {
    int size = p[node];
    int subBadNum = 0;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        Outcome subResult = search(p, h, adjLists, node, adj);
        if (subResult.badNum() == -1) {
          return new Outcome(0, -1);
        }

        size += subResult.size();
        subBadNum += subResult.badNum();
      }
    }

    if (!(h[node] >= -size && h[node] <= size && (h[node] - size) % 2 == 0)) {
      return new Outcome(0, -1);
    }

    int badNum = (size - h[node]) / 2;
    if (badNum - p[node] > subBadNum) {
      return new Outcome(0, -1);
    }

    return new Outcome(size, badNum);
  }
}

record Outcome(int size, int badNum) {}
