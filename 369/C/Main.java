import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n - 1];
    int[] y = new int[n - 1];
    int[] t = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      t[i] = sc.nextInt();
    }

    System.out.println(solve(x, y, t));

    sc.close();
  }

  static String solve(int[] x, int[] y, int[] t) {
    int n = x.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < x.length; ++i) {
      edgeLists[x[i] - 1].add(i);
      edgeLists[y[i] - 1].add(i);
    }

    boolean[] subtreeProblems = new boolean[n];
    search1(subtreeProblems, x, y, t, edgeLists, -1, 0);

    List<Integer> candidates = new ArrayList<>();
    if (subtreeProblems[0]) {
      search2(candidates, x, y, t, edgeLists, subtreeProblems, -1, 0);
    }

    return "%d\n%s"
        .formatted(
            candidates.size(),
            candidates.stream()
                .mapToInt(candidate -> candidate + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }

  static void search2(
      List<Integer> candidates,
      int[] x,
      int[] y,
      int[] t,
      List<Integer>[] edgeLists,
      boolean[] subtreeProblems,
      int parent,
      int node) {
    if (subtreeProblems[node]) {
      for (int edge : edgeLists[node]) {
        int adj = (x[edge] - 1 == node) ? (y[edge] - 1) : (x[edge] - 1);
        if (adj != parent) {
          if (t[edge] == 2 || subtreeProblems[adj]) {
            search2(candidates, x, y, t, edgeLists, subtreeProblems, node, adj);
          }
        }
      }
    } else {
      candidates.add(node);
    }
  }

  static void search1(
      boolean[] subtreeProblems,
      int[] x,
      int[] y,
      int[] t,
      List<Integer>[] edgeLists,
      int parent,
      int node) {
    for (int edge : edgeLists[node]) {
      int adj = (x[edge] - 1 == node) ? (y[edge] - 1) : (x[edge] - 1);
      if (adj != parent) {
        if (t[edge] == 2) {
          subtreeProblems[node] = true;
        }

        search1(subtreeProblems, x, y, t, edgeLists, node, adj);
        if (subtreeProblems[adj]) {
          subtreeProblems[node] = true;
        }
      }
    }
  }
}