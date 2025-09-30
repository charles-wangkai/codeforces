import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a));
  }

  static int solve(int[] a) {
    int[] dp = new int[a.length + 1];
    dp[0] = 1;

    for (int value : a) {
      List<Integer> lengths = new ArrayList<>();
      for (int i = 1; i < dp.length && i * i <= value; ++i) {
        if (value % i == 0) {
          lengths.add(i);

          if (value / i != i && value / i < dp.length) {
            lengths.add(value / i);
          }
        }
      }
      Collections.sort(lengths, Comparator.reverseOrder());

      for (int length : lengths) {
        dp[length] = addMod(dp[length], dp[length - 1]);
      }
    }

    return IntStream.range(1, dp.length).map(i -> dp[i]).reduce(Main::addMod).getAsInt();
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}