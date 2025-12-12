// https://codeforces.com/blog/entry/22971
// https://cp-algorithms.com/data_structures/sqrt_decomposition.html#mos-algorithm

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int[] l = new int[m];
    int[] r = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      l[i] = Integer.parseInt(st.nextToken());
      r[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, l, r, k));
  }

  static String solve(int[] a, int[] l, int[] r, int k) {
    int[] prefixXors = new int[a.length + 1];
    for (int i = 1; i < prefixXors.length; ++i) {
      prefixXors[i] = prefixXors[i - 1] ^ a[i - 1];
    }

    int blockSize = (int) Math.ceil(Math.sqrt(a.length));

    int[] sortedQueryIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> l[i] / blockSize)
                    .thenComparing(i -> r[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    long[] result = new long[l.length];
    State state = new State();
    int leftIndex = 0;
    int rightIndex = -1;
    for (int index : sortedQueryIndices) {
      int left = l[index] - 1;
      int right = r[index];

      while (leftIndex > left) {
        --leftIndex;
        state.add(k, prefixXors[leftIndex]);
      }
      while (rightIndex < right) {
        ++rightIndex;
        state.add(k, prefixXors[rightIndex]);
      }

      while (leftIndex < left) {
        state.remove(k, prefixXors[leftIndex]);
        ++leftIndex;
      }
      while (rightIndex > right) {
        state.remove(k, prefixXors[rightIndex]);
        --rightIndex;
      }

      result[index] = state.pairNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class State {
  static final int LIMIT = 1 << 20;

  int[] counts = new int[LIMIT];
  long pairNum;

  void add(int k, int prefixXor) {
    pairNum += counts[prefixXor ^ k];
    ++counts[prefixXor];
  }

  void remove(int k, int prefixXor) {
    --counts[prefixXor];
    pairNum -= counts[prefixXor ^ k];
  }
}
