import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] p = new int[n][m];
    for (int r = 0; r < n; ++r) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < m; ++c) {
        p[r][c] = Integer.parseInt(st.nextToken());
      }
    }
    String[] queries = new String[k];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = br.readLine();
    }

    System.out.println(solve(p, queries));
  }

  static String solve(int[][] p, String[] queries) {
    int n = p.length;
    int m = p[0].length;

    List<Integer> result = new ArrayList<>();
    int[] oldRows = IntStream.range(0, n).toArray();
    int[] oldCols = IntStream.range(0, m).toArray();
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("r")) {
        int r1 = Integer.parseInt(fields[1]) - 1;
        int r2 = Integer.parseInt(fields[2]) - 1;

        swap(oldRows, r1, r2);
      } else if (fields[0].equals("c")) {
        int c1 = Integer.parseInt(fields[1]) - 1;
        int c2 = Integer.parseInt(fields[2]) - 1;

        swap(oldCols, c1, c2);
      } else {
        int r = Integer.parseInt(fields[1]) - 1;
        int c = Integer.parseInt(fields[2]) - 1;

        result.add(p[oldRows[r]][oldCols[c]]);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}