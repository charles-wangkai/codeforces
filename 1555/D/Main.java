import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static final String[] TARGETS = {"abc", "acb", "bca", "bac", "cab", "cba"};

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    st.nextToken();
    int m = Integer.parseInt(st.nextToken());
    String s = br.readLine();
    int[] l = new int[m];
    int[] r = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      l[i] = Integer.parseInt(st.nextToken());
      r[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(s, l, r));
  }

  static String solve(String s, int[] l, int[] r) {
    int[][][] counts = new int[s.length() + 1][3][3];
    for (int i = 1; i < counts.length; ++i) {
      for (int j = 0; j < 3; ++j) {
        for (int k = 0; k < 3; ++k) {
          counts[i][j][k] =
              counts[i - 1][j][k] + (((i - 1) % 3 == j && s.charAt(i - 1) - 'a' == k) ? 1 : 0);
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < l.length; ++i) {
      if (i != 0) {
        result.append("\n");
      }

      int minOperationNum = Integer.MAX_VALUE;
      for (String target : TARGETS) {
        minOperationNum =
            Math.min(minOperationNum, computeOperationNum(counts, l[i], r[i], target));
      }
      result.append(minOperationNum);
    }

    return result.toString();
  }

  static int computeOperationNum(int[][][] counts, int left, int right, String target) {
    int result = 0;
    for (int i = 0; i < target.length(); ++i) {
      for (int j = 0; j < 3; ++j) {
        if (j != target.charAt(i) - 'a') {
          result += counts[right][i][j] - counts[left - 1][i][j];
        }
      }
    }

    return result;
  }
}
