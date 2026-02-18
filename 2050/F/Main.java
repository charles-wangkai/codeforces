import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] r) {
    if (a.length == 1) {
      return IntStream.range(0, l.length)
          .map(i -> 0)
          .mapToObj(String::valueOf)
          .collect(Collectors.joining(" "));
    }

    SparseTable sparseTable =
        new SparseTable(
            IntStream.range(0, a.length - 1).map(i -> Math.abs(a[i] - a[i + 1])).toArray(),
            Main::gcd);

    return IntStream.range(0, l.length)
        .map(i -> (l[i] < r[i]) ? sparseTable.query(l[i] - 1, r[i] - 2) : 0)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
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
