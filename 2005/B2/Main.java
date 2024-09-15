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
      int q = Integer.parseInt(st.nextToken());
      int[] b = new int[m];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < b.length; ++i) {
        b[i] = Integer.parseInt(st.nextToken());
      }
      int[] a = new int[q];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(n, b, a));
    }
  }

  static String solve(int n, int[] b, int[] a) {
    Arrays.sort(b);

    return Arrays.stream(a)
        .map(
            ai -> {
              if (ai < b[0]) {
                return b[0] - 1;
              }
              if (ai > b[b.length - 1]) {
                return n - b[b.length - 1];
              }

              int index = -Arrays.binarySearch(b, ai) - 1;

              return (b[index] - b[index - 1]) / 2;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}