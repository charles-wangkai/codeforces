import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] u = new int[n - 1];
        int[] v = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            u[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(u, v, k));

        sc.close();
    }

    static long solve(int[] u, int[] v, int k) {
        int n = u.length + 1;

        @SuppressWarnings("unchecked")
        List<Integer>[] adjLists = new List[n];
        for (int i = 0; i < adjLists.length; ++i) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < u.length; ++i) {
            adjLists[u[i]].add(v[i]);
            adjLists[v[i]].add(u[i]);
        }

        List<Integer> deltas = new ArrayList<>();
        search(deltas, adjLists, new boolean[n], 0, 0);

        return deltas.stream().sorted(Collections.reverseOrder()).limit(k).mapToLong(x -> x).sum();
    }

    static int search(List<Integer> deltas, List<Integer>[] adjLists, boolean[] visited, int node, int depth) {
        visited[node] = true;

        int childNum = 0;
        for (int adj : adjLists[node]) {
            if (!visited[adj]) {
                childNum += search(deltas, adjLists, visited, adj, depth + 1);
            }
        }

        deltas.add(depth - childNum);

        return childNum + 1;
    }
}