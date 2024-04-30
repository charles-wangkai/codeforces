import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] p = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < p.length; ++i) {
        p[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(p));
    }
  }

  static int solve(int[] p) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < p.length; ++i) {
      for (int j = i + 1; j < p.length; ++j) {
        result =
            Math.min(
                result,
                Long.bitCount((1L << (i + 1)) | (1L << p[i]) | (1L << (j + 1)) | (1L << p[j])));
      }
    }

    return result;
  }
}