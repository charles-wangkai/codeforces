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
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }
      int[] b = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < b.length; ++i) {
        b[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, b));
    }
  }

  static int solve(int[] a, int[] b) {
    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(a).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, b, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int[] b, int time) {
    long needed = 0;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > time) {
        needed += b[i];
      }
    }

    return needed <= time;
  }
}
