import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < u.length; ++i) {
        u[i] = sc.nextInt() - 1;
        v[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i]].add(i);
      edgeLists[v[i]].add(i);
    }

    boolean[] drawn = new boolean[n];
    drawn[0] = true;
    NavigableSet<Integer> availableEdges = new TreeSet<>();
    for (int i = 0; i < u.length; ++i) {
      if (u[i] == 0 || v[i] == 0) {
        availableEdges.add(i);
      }
    }

    int result = 0;
    int edge = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; ++i) {
      Integer nextEdge = availableEdges.higher(edge);
      if (nextEdge == null) {
        ++result;
        nextEdge = availableEdges.first();
      }

      availableEdges.remove(nextEdge);

      int nextNode = drawn[u[nextEdge]] ? v[nextEdge] : u[nextEdge];
      drawn[nextNode] = true;
      for (int e : edgeLists[nextNode]) {
        if (!drawn[(u[e] == nextNode) ? v[e] : u[e]]) {
          availableEdges.add(e);
        }
      }

      edge = nextEdge;
    }

    return result;
  }
}
