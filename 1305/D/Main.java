import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        @SuppressWarnings("unchecked")
        Set<Integer>[] adjSets = new Set[n + 1];
        for (int i = 0; i < adjSets.length; ++i) {
            adjSets[i] = new HashSet<>();
        }
        for (int i = 0; i < n - 1; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            adjSets[x].add(y);
            adjSets[y].add(x);
        }

        Set<Integer> candidates = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        while (candidates.size() != 1) {
            int[] leaves = candidates.stream().filter(candidate -> adjSets[candidate].size() == 1).mapToInt(x -> x)
                    .toArray();

            int u = leaves[0];
            int v = leaves[1];
            System.out.println(String.format("? %d %d", u, v));
            System.out.flush();

            int w = sc.nextInt();

            Set<Integer> toBeRemoved = new HashSet<>();
            find(toBeRemoved, adjSets, u, w, new ArrayList<>(), new boolean[n + 1]);
            find(toBeRemoved, adjSets, v, w, new ArrayList<>(), new boolean[n + 1]);

            candidates.removeAll(toBeRemoved);

            for (Set<Integer> adjSet : adjSets) {
                adjSet.removeAll(toBeRemoved);
            }

            candidates.clear();
            dfs(candidates, adjSets, w, new boolean[n + 1]);
        }

        System.out.println(String.format("! %d", candidates.iterator().next()));
        System.out.flush();

        sc.close();
    }

    static void dfs(Set<Integer> candidates, Set<Integer>[] adjSets, int node, boolean[] visited) {
        candidates.add(node);
        visited[node] = true;

        for (int adj : adjSets[node]) {
            if (!visited[adj]) {
                dfs(candidates, adjSets, adj, visited);
            }
        }
    }

    static void find(Set<Integer> toBeRemoved, Set<Integer>[] adjSets, int node, int target, List<Integer> path,
            boolean[] visited) {
        visited[node] = true;

        if (node == target) {
            toBeRemoved.addAll(path);

            return;
        }

        path.add(node);

        for (int adj : adjSets[node]) {
            if (!visited[adj]) {
                find(toBeRemoved, adjSets, adj, target, path, visited);
            }
        }

        path.remove(path.size() - 1);
    }
}