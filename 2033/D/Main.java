import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a));
    }
  }

  static int solve(int[] a) {
    int result = 0;
    Set<Long> seen = new HashSet<>();
    seen.add(0L);
    long prefixSum = 0;
    for (int ai : a) {
      prefixSum += ai;
      if (seen.contains(prefixSum)) {
        ++result;

        seen = new HashSet<>();
        seen.add(0L);
        prefixSum = 0;
      } else {
        seen.add(prefixSum);
      }
    }

    return result;
  }
}