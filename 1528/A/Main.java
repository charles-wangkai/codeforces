import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        st = new StringTokenizer(br.readLine());
        l[i] = Integer.parseInt(st.nextToken());
        r[i] = Integer.parseInt(st.nextToken());
      }
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        st = new StringTokenizer(br.readLine());
        u[i] = Integer.parseInt(st.nextToken()) - 1;
        v[i] = Integer.parseInt(st.nextToken()) - 1;
      }

      System.out.println(solve(l, r, u, v));
    }
  }

  static long solve(int[] l, int[] r, int[] u, int[] v) {
    int n = l.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i]].add(v[i]);
      adjLists[v[i]].add(u[i]);
    }

    Candidate[] candidates = search(l, r, adjLists, new boolean[n], 0);

    return Math.max(candidates[0].sum, candidates[1].sum);
  }

  static Candidate[] search(
      int[] l, int[] r, List<Integer>[] adjLists, boolean[] visited, int node) {
    visited[node] = true;

    Candidate[] candidates = new Candidate[2];
    candidates[0] = new Candidate(l[node], 0);
    candidates[1] = new Candidate(r[node], 0);

    for (int adj : adjLists[node]) {
      if (!visited[adj]) {
        Candidate[] subCandidates = search(l, r, adjLists, visited, adj);
        for (Candidate candidate : candidates) {
          candidate.sum +=
              Math.max(
                  subCandidates[0].sum + Math.abs(candidate.value - subCandidates[0].value),
                  subCandidates[1].sum + Math.abs(candidate.value - subCandidates[1].value));
        }
      }
    }

    return candidates;
  }
}

class Candidate {
  int value;
  long sum;

  Candidate(int value, long sum) {
    this.value = value;
    this.sum = sum;
  }
}