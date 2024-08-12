import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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

  static String solve(int[] a, int[] b) {
    return (Arrays.equals(a, b)
            || IntStream.range(0, a.length).allMatch(i -> a[i] == b[b.length - 1 - i]))
        ? "Bob"
        : "Alice";
  }
}