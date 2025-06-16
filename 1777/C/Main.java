import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, m));
    }
  }

  static int solve(int[] a, int m) {
    Arrays.sort(a);

    Map<Integer, List<Integer>> valueToDivisors = new HashMap<>();
    for (int value : a) {
      List<Integer> divisors = new ArrayList<>();
      for (int i = 1; i * i <= value; ++i) {
        if (value % i == 0) {
          if (i <= m) {
            divisors.add(i);
          }
          if (value / i != i && value / i <= m) {
            divisors.add(value / i);
          }
        }
      }

      valueToDivisors.put(value, divisors);
    }

    int result = -1;
    int lower = 0;
    int upper = a[a.length - 1] - a[0];
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, m, valueToDivisors, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int m, Map<Integer, List<Integer>> valueToDivisors, int diffLimit) {
    int[] counts = new int[m + 1];
    int covered = 0;
    int beginIndex = 0;
    for (int endIndex = 0; endIndex < a.length; ++endIndex) {
      for (int divisor : valueToDivisors.get(a[endIndex])) {
        if (counts[divisor] == 0) {
          ++covered;
        }
        ++counts[divisor];
      }

      while (a[endIndex] - a[beginIndex] > diffLimit) {
        for (int divisor : valueToDivisors.get(a[beginIndex])) {
          --counts[divisor];
          if (counts[divisor] == 0) {
            --covered;
          }
        }

        ++beginIndex;
      }

      if (covered == m) {
        return true;
      }
    }

    return false;
  }
}