import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] s = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < s.length; ++i) {
      s[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    int[] l = new int[t];
    int[] r = new int[t];
    for (int i = 0; i < t; ++i) {
      st = new StringTokenizer(br.readLine());
      l[i] = Integer.parseInt(st.nextToken());
      r[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(s, l, r));
  }

  static String solve(int[] s, int[] l, int[] r) {
    SparseTable minSparseTable = new SparseTable(s, Math::min);
    SparseTable gcdSparseTable = new SparseTable(s, Main::gcd);

    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < s.length; ++i) {
      valueToIndices.putIfAbsent(s[i], new ArrayList<>());
      valueToIndices.get(s[i]).add(i);
    }

    return IntStream.range(0, l.length)
        .map(
            i -> {
              int min = minSparseTable.query(l[i] - 1, r[i] - 1);

              return (r[i] - l[i] + 1)
                  - ((gcdSparseTable.query(l[i] - 1, r[i] - 1) % min == 0)
                      ? computeRangeNum(valueToIndices.get(min), l[i] - 1, r[i] - 1)
                      : 0);
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int computeRangeNum(List<Integer> indices, int beginIndex, int endIndex) {
    int from = Collections.binarySearch(indices, beginIndex);
    if (from < 0) {
      from = -1 - from;
    }

    int to = Collections.binarySearch(indices, endIndex);
    if (to < 0) {
      to = -2 - to;
    }

    return to - from + 1;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}

class SparseTable {
  int[][] st;
  BinaryOperator<Integer> binaryOperator;

  SparseTable(int[] values, BinaryOperator<Integer> binaryOperator) {
    st = new int[values.length][computeExponent(values.length) + 1];
    for (int i = 0; i < st.length; ++i) {
      st[i][0] = values[i];
    }
    for (int exponent = 1; exponent < st[0].length; ++exponent) {
      for (int i = 0; i + (1 << exponent) <= st.length; ++i) {
        st[i][exponent] =
            binaryOperator.apply(st[i][exponent - 1], st[i + (1 << (exponent - 1))][exponent - 1]);
      }
    }

    this.binaryOperator = binaryOperator;
  }

  int query(int beginIndex, int endIndex) {
    int exponent = computeExponent(endIndex - beginIndex + 1);

    return binaryOperator.apply(
        st[beginIndex][exponent], st[endIndex - (1 << exponent) + 1][exponent]);
  }

  private int computeExponent(int x) {
    return 31 - Integer.numberOfLeadingZeros(x);
  }
}
