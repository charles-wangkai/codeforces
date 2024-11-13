import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static final int LIMIT = 100;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] sequences = new int[n][];
    for (int i = 0; i < sequences.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      sequences[i] = new int[k];
      for (int j = 0; j < sequences[i].length; ++j) {
        sequences[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] queries = new int[m][];
    for (int i = 0; i < queries.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      queries[i] = new int[l];
      for (int j = 0; j < queries[i].length; ++j) {
        queries[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(sequences, queries));
  }

  static String solve(int[][] sequences, int[][] queries) {
    boolean[][] seens = new boolean[sequences.length][LIMIT + 1];
    for (int i = 0; i < sequences.length; ++i) {
      for (int x : sequences[i]) {
        seens[i][x] = true;
      }
    }

    StringBuilder result = new StringBuilder();
    for (int[] query : queries) {
      List<String> found = new ArrayList<>();
      for (int i = 0; i < sequences.length; ++i) {
        if (isMatch(query, seens[i])) {
          StringBuilder sb = new StringBuilder().append(sequences[i].length);
          for (int x : sequences[i]) {
            sb.append(" ").append(x);
          }

          found.add(sb.toString());
        }
      }

      result.append("%d\n%s\n".formatted(found.size(), String.join("\n", found)));
    }

    return result.toString();
  }

  static boolean isMatch(int[] query, boolean[] seen) {
    for (int x : query) {
      if ((x > 0 && !seen[x]) || (x < 0 && seen[-x])) {
        return false;
      }
    }

    return true;
  }
}