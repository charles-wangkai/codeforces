import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int p = sc.nextInt();
    int[] a = new int[p];
    int[] b = new int[p];
    int[] d = new int[p];
    for (int i = 0; i < p; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b, d));

    sc.close();
  }

  static String solve(int n, int[] a, int[] b, int[] d) {
    int[] edges = new int[n];
    Arrays.fill(edges, -1);

    boolean[] hasIncomings = new boolean[n];

    for (int i = 0; i < a.length; ++i) {
      edges[a[i] - 1] = i;
      hasIncomings[b[i] - 1] = true;
    }

    List<String> pairs = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (!hasIncomings[i] && edges[i] != -1) {
        int tank = i;
        int tap = i;
        int diameter = Integer.MAX_VALUE;
        while (edges[tap] != -1) {
          diameter = Math.min(diameter, d[edges[tap]]);
          tap = b[edges[tap]] - 1;
        }

        pairs.add("%d %d %d".formatted(tank + 1, tap + 1, diameter));
      }
    }

    return "%d\n%s".formatted(pairs.size(), String.join("\n", pairs));
  }
}