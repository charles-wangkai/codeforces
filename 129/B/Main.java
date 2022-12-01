import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static int solve(int n, int[] a, int[] b) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[n];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }
    for (int i = 0; i < a.length; ++i) {
      adjSets[a[i]].add(b[i]);
      adjSets[b[i]].add(a[i]);
    }

    int result = 0;
    while (true) {
      int[] singleTied =
          IntStream.range(0, adjSets.length).filter(i -> adjSets[i].size() == 1).toArray();
      if (singleTied.length == 0) {
        return result;
      }

      for (int u : singleTied) {
        for (int v : adjSets[u]) {
          adjSets[v].remove(u);
        }
        adjSets[u].clear();
      }

      ++result;
    }
  }
}
