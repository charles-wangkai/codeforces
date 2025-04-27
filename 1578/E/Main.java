import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int h = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      System.out.println(solve(h, p));
    }
  }

  static long solve(int h, int p) {
    long result = 0;
    long[] rests = IntStream.range(0, h).mapToLong(i -> 1L << i).toArray();
    for (int i = 0; i < rests.length; ++i) {
      result += rests[i] / p;

      long remainder = rests[i] % p;
      if (remainder != 0) {
        if (i != rests.length - 1) {
          rests[i + 1] -= Math.min(p - remainder, ((1L << i) - remainder) * 2);
        }

        ++result;
      }
    }

    return result;
  }
}