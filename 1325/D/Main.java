import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int BIT_LIMIT = 60;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long u = sc.nextLong();
    long v = sc.nextLong();

    System.out.println(solve(u, v));

    sc.close();
  }

  static String solve(long u, long v) {
    if (u > v || (u & 1) != (v & 1)) {
      return "-1";
    }

    long[] values = new long[3];
    for (int i = 0; i < BIT_LIMIT; ++i) {
      int oneCount = (int) ((u >> i) & 1) + (int) (((v - u) >> (i + 1)) & 1) * 2;
      for (int j = 0; j < oneCount; ++j) {
        values[j] += 1L << i;
      }
    }

    long[] elements = Arrays.stream(values).filter(x -> x != 0).toArray();

    return String.format(
        "%d\n%s",
        elements.length,
        Arrays.stream(elements).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
