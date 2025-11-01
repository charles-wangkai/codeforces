import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextInt();
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }
    int start = sc.nextInt();

    System.out.println(solve(u, v, start));

    sc.close();
  }

  static String solve(int[] u, int[] v, int start) {
    int n = u.length + 1;

    if (n % 2 == 0) {
      return "Ron";
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] adjList = new List[n];
    for (int i = 0; i < adjList.length; ++i) {
      adjList[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjList[u[i] - 1].add(v[i] - 1);
      adjList[v[i] - 1].add(u[i] - 1);
    }

    int[] degrees = new int[n];
    for (int i = 0; i < u.length; ++i) {
      ++degrees[u[i] - 1];
      ++degrees[v[i] - 1];
    }

    int parent = -1;
    int node = IntStream.range(0, degrees.length).filter(i -> degrees[i] == 1).findAny().getAsInt();
    boolean firstWin = false;
    while (node != start - 1) {
      int parent_ = parent;
      int next = adjList[node].stream().filter(adj -> adj != parent_).findAny().get();

      parent = node;
      node = next;
      firstWin ^= true;
    }

    return firstWin ? "Ron" : "Hermione";
  }
}