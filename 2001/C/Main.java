import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      int[] parents = new int[n];
      Arrays.fill(parents, -1);

      StringBuilder result = new StringBuilder("!");
      for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
          if (findRoot(parents, i) != findRoot(parents, j)) {
            int v1 = i;
            int v2 = j;
            while (true) {
              System.out.println("? %d %d".formatted(v1 + 1, v2 + 1));
              System.out.flush();

              int x = sc.nextInt() - 1;
              if (x == v1) {
                result.append(" ").append(v1 + 1).append(" ").append(v2 + 1);
                parents[findRoot(parents, v2)] = findRoot(parents, v1);

                break;
              }

              if (findRoot(parents, x) != findRoot(parents, v1)) {
                v2 = x;
              } else {
                v1 = x;
              }
            }
          }
        }
      }

      System.out.println(result);
      System.out.flush();
    }

    sc.close();
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}