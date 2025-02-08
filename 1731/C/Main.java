import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  static long solve(int[] a) {
    int n = a.length;

    int limit = Integer.highestOneBit(Arrays.stream(a).max().getAsInt()) * 2;

    List<Integer> oddNumDivisorValues = new ArrayList<>();
    for (int i = 0; ; ++i) {
      int oddNumDivisorValue = i * i;
      if (oddNumDivisorValue > limit) {
        break;
      }

      oddNumDivisorValues.add(oddNumDivisorValue);
    }

    long result = n * (n + 1L) / 2;
    int[] counts = new int[limit + 1];
    counts[0] = 1;
    int xor = 0;
    for (int ai : a) {
      xor ^= ai;
      for (int oddNumDivisorValue : oddNumDivisorValues) {
        int other = xor ^ oddNumDivisorValue;
        if (other < counts.length) {
          result -= counts[other];
        }
      }

      ++counts[xor];
    }

    return result;
  }
}