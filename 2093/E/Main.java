import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, k));
    }
  }

  static int solve(int[] a, int k) {
    int result = 0;
    int lower = 1;
    int upper = Arrays.stream(a).max().getAsInt() + 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, k, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int k, int target) {
    int subarrayCount = 0;
    int[] seen = new int[a.length + 1];
    int mex = 0;
    for (int ai : a) {
      if (ai < seen.length) {
        seen[ai] = subarrayCount + 1;
      }
      while (seen[mex] == subarrayCount + 1) {
        ++mex;
      }

      if (mex >= target) {
        ++subarrayCount;
        mex = 0;
      }
    }

    return subarrayCount >= k;
  }
}