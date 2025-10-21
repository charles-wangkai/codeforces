import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c));

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] c) {
    int n = a.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      edgeLists[a[i] - 1].add(i);
      edgeLists[b[i] - 1].add(i);
    }

    Set<Integer> seen = new HashSet<>();
    seen.add(0);
    int node = 0;
    int costSum = 0;
    do {
      for (int edge : edgeLists[node]) {
        int other = (a[edge] - 1 == node) ? (b[edge] - 1) : (a[edge] - 1);
        if (!seen.contains(other) || (other == 0 && seen.size() == n)) {
          if (b[edge] - 1 == node) {
            costSum += c[edge];
          }

          node = other;
          seen.add(node);

          break;
        }
      }
    } while (node != 0);

    return Math.min(costSum, Arrays.stream(c).sum() - costSum);
  }
}