import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] a = new long[n];
    long[] b = new long[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextLong();
      b[i] = sc.nextLong();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static long solve(long[] a, long[] b) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing((Integer i) -> b[i]).reversed())
            .mapToInt(x -> x)
            .toArray();

    long buyNum = Arrays.stream(a).sum();
    long result = buyNum * 2;
    for (int index : sortedIndices) {
      long discountNum = Math.min(a[index], Math.max(0, buyNum - b[index]));
      result -= discountNum;
      buyNum -= discountNum;
    }

    return result;
  }
}
