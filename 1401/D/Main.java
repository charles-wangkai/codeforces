import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] p = new int[m];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(u, v, p));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v, int[] p) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    List<Long> weights = new ArrayList<>();
    buildWeights(weights, adjLists, -1, 0);
    Collections.sort(weights);

    Arrays.sort(p);

    int[] labels = new int[n - 1];
    Arrays.fill(labels, 1);

    int index = Math.max(0, labels.length - p.length);
    for (int pi : p) {
      labels[index] = multiplyMod(labels[index], pi);

      if (index != labels.length - 1) {
        ++index;
      }
    }

    return IntStream.range(0, weights.size())
        .map(i -> multiplyMod(mod(weights.get(i)), labels[i]))
        .reduce(Main::addMod)
        .getAsInt();
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int mod(long x) {
    return (int) (x % MODULUS);
  }

  static int buildWeights(List<Long> weights, List<Integer>[] adjLists, int parent, int node) {
    int n = adjLists.length;

    int subtreeSize = 1;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        subtreeSize += buildWeights(weights, adjLists, node, adj);
      }
    }

    if (parent != -1) {
      weights.add((long) subtreeSize * (n - subtreeSize));
    }

    return subtreeSize;
  }
}