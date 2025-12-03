import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(n, x, y) ? "FHTAGN!" : "NO");

    sc.close();
  }

  static boolean solve(int n, int[] x, int[] y) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[n];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }
    for (int i = 0; i < x.length; ++i) {
      adjSets[x[i] - 1].add(y[i] - 1);
      adjSets[y[i] - 1].add(x[i] - 1);
    }

    if (Arrays.stream(adjSets).anyMatch(Set::isEmpty)) {
      return false;
    }

    Queue<Integer> leaves = new ArrayDeque<>();
    for (int i = 0; i < adjSets.length; ++i) {
      if (adjSets[i].size() == 1) {
        leaves.offer(i);
      }
    }

    while (!leaves.isEmpty()) {
      int head = leaves.poll();
      if (adjSets[head].size() == 1) {
        int other = adjSets[head].iterator().next();
        adjSets[head].remove(other);
        adjSets[other].remove(head);

        if (adjSets[other].size() == 1) {
          leaves.offer(other);
        }
      }
    }

    int[] nonOrphans =
        IntStream.range(0, adjSets.length).filter(i -> !adjSets[i].isEmpty()).toArray();

    return nonOrphans.length >= 3
        && Arrays.stream(nonOrphans).allMatch(nonOrphan -> adjSets[nonOrphan].size() == 2)
        && search(adjSets, new HashSet<>(), nonOrphans[0]) == nonOrphans.length;
  }

  static int search(Set<Integer>[] adjSets, Set<Integer> visited, int node) {
    if (visited.contains(node)) {
      return 0;
    }

    visited.add(node);

    int result = 1;
    for (int adj : adjSets[node]) {
      result += search(adjSets, visited, adj);
    }

    return result;
  }
}