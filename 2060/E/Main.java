import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m1 = sc.nextInt();
      int m2 = sc.nextInt();
      int[] fu = new int[m1];
      int[] fv = new int[m1];
      for (int i = 0; i < m1; ++i) {
        fu[i] = sc.nextInt();
        fv[i] = sc.nextInt();
      }
      int[] gu = new int[m2];
      int[] gv = new int[m2];
      for (int i = 0; i < m2; ++i) {
        gu[i] = sc.nextInt();
        gv[i] = sc.nextInt();
      }

      System.out.println(solve(n, fu, fv, gu, gv));
    }

    sc.close();
  }

  static int solve(int n, int[] fu, int[] fv, int[] gu, int[] gv) {
    int[] gParents = new int[n];
    Arrays.fill(gParents, -1);
    for (int i = 0; i < gu.length; ++i) {
      int root1 = findRoot(gParents, gu[i] - 1);
      int root2 = findRoot(gParents, gv[i] - 1);
      if (root1 != root2) {
        gParents[root2] = root1;
      }
    }

    int result = 0;
    int[] fParents = new int[n];
    Arrays.fill(fParents, -1);
    for (int i = 0; i < fu.length; ++i) {
      if (findRoot(gParents, fu[i] - 1) != findRoot(gParents, fv[i] - 1)) {
        ++result;
      } else {
        int root1 = findRoot(fParents, fu[i] - 1);
        int root2 = findRoot(fParents, fv[i] - 1);
        if (root1 != root2) {
          fParents[root2] = root1;
        }
      }
    }
    result +=
        IntStream.range(0, n).map(i -> findRoot(fParents, i)).distinct().count()
            - IntStream.range(0, n).map(i -> findRoot(gParents, i)).distinct().count();

    return result;
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}