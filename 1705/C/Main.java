import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int c = sc.nextInt();
      int q = sc.nextInt();
      String s = sc.next();
      long[] l = new long[c];
      long[] r = new long[c];
      for (int i = 0; i < c; ++i) {
        l[i] = sc.nextLong() - 1;
        r[i] = sc.nextLong() - 1;
      }
      long[] k = new long[q];
      for (int i = 0; i < k.length; ++i) {
        k[i] = sc.nextLong() - 1;
      }

      System.out.println(solve(s, l, r, k));
    }

    sc.close();
  }

  static String solve(String s, long[] l, long[] r, long[] k) {
    BigInteger[] lengths = new BigInteger[l.length + 1];
    lengths[0] = BigInteger.valueOf(s.length());
    for (int i = 1; i < lengths.length; ++i) {
      lengths[i] = lengths[i - 1].add(BigInteger.valueOf(r[i - 1] - l[i - 1] + 1));
    }

    return Arrays.stream(k)
        .mapToObj(
            ki -> {
              int index = 0;
              while (ki >= lengths[index].longValue()) {
                ++index;
              }

              for (int i = index; i >= 1; --i) {
                if (ki >= lengths[i - 1].longValue()) {
                  ki = ki - lengths[i - 1].longValue() + l[i - 1];
                }
              }

              return String.valueOf(s.charAt((int) ki));
            })
        .collect(Collectors.joining("\n"));
  }
}