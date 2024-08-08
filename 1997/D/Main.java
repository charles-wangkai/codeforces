import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Runnable {
  public static void main(String[] args) {
    new Thread(null, new Main(), "Main", 1 << 28).start();
  }

  public void run() {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] p = new int[n - 1];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(a, p));
    }

    sc.close();
  }

  static int solve(int[] a, int[] p) {
    int n = a.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      childLists[p[i] - 1].add(i + 1);
    }

    return a[0]
        + childLists[0].stream().mapToInt(node -> search(a, childLists, node)).min().getAsInt();
  }

  static int search(int[] a, List<Integer>[] childLists, int node) {
    if (childLists[node].isEmpty()) {
      return a[node];
    }

    int minSub =
        childLists[node].stream().mapToInt(child -> search(a, childLists, child)).min().getAsInt();

    return (a[node] < minSub) ? ((a[node] + minSub) / 2) : minSub;
  }
}