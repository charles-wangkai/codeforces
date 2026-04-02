import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      int[] w = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
        w[i] = sc.nextInt();
      }

      System.out.println(solve(u, v, w, a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] u, int[] v, int[] w, int a, int b) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i] - 1].add(i);
      edgeLists[v[i] - 1].add(i);
    }

    Set<Integer> fromXors = new HashSet<>();
    searchFrom(fromXors, u, v, w, b, edgeLists, -1, a - 1, 0);

    Set<Integer> toXors = new HashSet<>();
    searchTo(toXors, u, v, w, b, edgeLists, -1, b - 1, 0);

    return toXors.stream().anyMatch(fromXors::contains);
  }

  static void searchTo(
      Set<Integer> toXors,
      int[] u,
      int[] v,
      int[] w,
      int b,
      List<Integer>[] edgeLists,
      int parent,
      int node,
      int xor) {
    if (node != b - 1) {
      toXors.add(xor);
    }

    for (int edge : edgeLists[node]) {
      int other = (u[edge] - 1 == node) ? (v[edge] - 1) : (u[edge] - 1);
      if (other != parent) {
        searchTo(toXors, u, v, w, b, edgeLists, node, other, xor ^ w[edge]);
      }
    }
  }

  static void searchFrom(
      Set<Integer> fromXors,
      int[] u,
      int[] v,
      int[] w,
      int b,
      List<Integer>[] edgeLists,
      int parent,
      int node,
      int xor) {
    fromXors.add(xor);

    for (int edge : edgeLists[node]) {
      int other = (u[edge] - 1 == node) ? (v[edge] - 1) : (u[edge] - 1);
      if (other != parent && other != b - 1) {
        searchFrom(fromXors, u, v, w, b, edgeLists, node, other, xor ^ w[edge]);
      }
    }
  }
}