import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] a = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());
    int[] xs = new int[q];
    int[] ys = new int[q];
    int[] xf = new int[q];
    int[] yf = new int[q];
    int[] k = new int[q];
    for (int i = 0; i < q; ++i) {
      st = new StringTokenizer(br.readLine());
      xs[i] = Integer.parseInt(st.nextToken());
      ys[i] = Integer.parseInt(st.nextToken());
      xf[i] = Integer.parseInt(st.nextToken());
      yf[i] = Integer.parseInt(st.nextToken());
      k[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, a, xs, ys, xf, yf, k));
  }

  static String solve(int n, int[] a, int[] xs, int[] ys, int[] xf, int[] yf, int[] k) {
    SparseTable sparseTable = new SparseTable(a, Math::max);

    return IntStream.range(0, xs.length)
        .mapToObj(
            i ->
                ((xs[i] - xf[i]) % k[i] == 0
                        && (ys[i] - yf[i]) % k[i] == 0
                        && sparseTable.query(Math.min(ys[i], yf[i]) - 1, Math.max(ys[i], yf[i]) - 1)
                            < xs[i] + (n - xs[i]) / k[i] * k[i])
                    ? "YES"
                    : "NO")
        .collect(Collectors.joining("\n"));
  }
}

class SparseTable {
  int[][] st;
  BinaryOperator<Integer> operator;

  SparseTable(int[] values, BinaryOperator<Integer> operator) {
    st = new int[values.length][computeExponent(values.length) + 1];
    for (int i = 0; i < st.length; ++i) {
      st[i][0] = values[i];
    }
    for (int exponent = 1; exponent < st[0].length; ++exponent) {
      for (int i = 0; i + (1 << exponent) <= st.length; ++i) {
        st[i][exponent] =
            operator.apply(st[i][exponent - 1], st[i + (1 << (exponent - 1))][exponent - 1]);
      }
    }

    this.operator = operator;
  }

  int query(int beginIndex, int endIndex) {
    int exponent = computeExponent(endIndex - beginIndex + 1);

    return operator.apply(st[beginIndex][exponent], st[endIndex - (1 << exponent) + 1][exponent]);
  }

  private int computeExponent(int x) {
    return 31 - Integer.numberOfLeadingZeros(x);
  }
}
