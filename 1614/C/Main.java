import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 30;
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] l = new int[m];
      int[] r = new int[m];
      int[] x = new int[m];
      for (int i = 0; i < m; ++i) {
        st = new StringTokenizer(br.readLine());
        l[i] = Integer.parseInt(st.nextToken());
        r[i] = Integer.parseInt(st.nextToken());
        x[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(n, l, r, x));
    }
  }

  static int solve(int n, int[] l, int[] r, int[] x) {
    int twoPower = IntStream.range(0, n - 1).reduce(1, (acc, e) -> multiplyMod(acc, 2));

    int or = Arrays.stream(x).reduce((acc, e) -> acc | e).getAsInt();

    int result = 0;
    int placeValue = 1;
    for (int i = 0; i < BIT_NUM; ++i) {
      if (((or >> i) & 1) == 1) {
        result = addMod(result, multiplyMod(placeValue, twoPower));
      }

      placeValue = multiplyMod(placeValue, 2);
    }

    return result;
  }

  static int addMod(int a, int b) {
    return Math.floorMod(a + b, MODULUS);
  }

  static int multiplyMod(int a, int b) {
    return Math.floorMod((long) a * b, MODULUS);
  }
}