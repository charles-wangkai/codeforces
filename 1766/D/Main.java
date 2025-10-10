import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static final int LIMIT = 10_000_000;

  static int[] divisors;

  public static void main(String[] args) throws Throwable {
    precompute();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < n; ++tc) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      System.out.println(solve(x, y));
    }
  }

  static void precompute() {
    divisors = new int[LIMIT];
    for (int i = 2; i < divisors.length; ++i) {
      if (divisors[i] == 0) {
        for (int j = i; j < divisors.length; j += i) {
          divisors[j] = i;
        }
      }
    }
  }

  static int solve(int x, int y) {
    if (y - x == 1) {
      return -1;
    }

    int result = Integer.MAX_VALUE;
    int rest = y - x;
    while (rest != 1) {
      result = Math.min(result, Math.ceilDiv(x, divisors[rest]) * divisors[rest] - x);

      rest /= divisors[rest];
    }

    return result;
  }
}