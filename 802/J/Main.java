import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    int[] c = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(u, v, c));

    sc.close();
  }

  static int solve(int[] u, int[] v, int[] c) {
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

    return search(u, v, c, edgeLists, 0, -1, 0);
  }

  static int search(
      int[] u, int[] v, int[] c, List<Integer>[] edgeLists, int costSum, int parent, int node) {
    int result = costSum;
    for (int edge : edgeLists[node]) {
      int other = (u[edge] == node) ? v[edge] : u[edge];
      if (other != parent) {
        result = Math.max(result, search(u, v, c, edgeLists, costSum + c[edge], node, other));
      }
    }

    return result;
  }
}