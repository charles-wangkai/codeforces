import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    StringBuilder output = new StringBuilder();
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      long n = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      output.append(solve(n, b, c)).append("\n");
    }
    System.out.print(output);
  }

  static long solve(long n, long b, long c) {
    if (b == 0) {
      if (c >= n) {
        return n;
      }
      if (c == n - 1 || c == n - 2) {
        return n - 1;
      }

      return -1;
    }

    long index = -1;
    long lower = 0;
    long upper = n - 1;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(n, b, c, middle)) {
        index = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return n - (index + 1);
  }

  static boolean check(long n, long b, long c, long index) {
    return index <= (Long.MAX_VALUE - c) / b && b * index + c < n;
  }
}