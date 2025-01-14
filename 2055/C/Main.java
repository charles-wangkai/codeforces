import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < m; ++c) {
          a[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      System.out.println(solve(a, s));
    }
  }

  static String solve(int[][] a, String s) {
    int n = a.length;
    int m = a[0].length;

    long[][] result = new long[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        result[r][c] = a[r][c];
      }
    }

    long[] rowSums = new long[n];
    long[] colSums = new long[m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        rowSums[r] += a[r][c];
        colSums[c] += a[r][c];
      }
    }

    int r = 0;
    int c = 0;
    for (char move : s.toCharArray()) {
      if (move == 'D') {
        result[r][c] = -rowSums[r];
        colSums[c] += result[r][c];
        ++r;
      } else {
        result[r][c] = -colSums[c];
        rowSums[r] += result[r][c];
        ++c;
      }
    }
    result[r][c] = -rowSums[r];

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}