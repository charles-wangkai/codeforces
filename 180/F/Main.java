import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
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

  static String solve(int[] a, int[] b) {
    int n = a.length;

    int[] result = new int[n];
    for (int i = 0; i < a.length; ++i) {
      result[a[i] - 1] = b[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}