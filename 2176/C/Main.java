import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    long total = Arrays.stream(a).asLongStream().sum();

    int[] evens =
        Arrays.stream(a)
            .filter(ai -> ai % 2 == 0)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    long[] evenPrefixSums = new long[evens.length + 1];
    for (int i = 1; i < evenPrefixSums.length; ++i) {
      evenPrefixSums[i] = evenPrefixSums[i - 1] + evens[i - 1];
    }

    int[] odds =
        Arrays.stream(a)
            .filter(ai -> ai % 2 == 1)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return IntStream.rangeClosed(1, a.length)
        .mapToLong(
            k -> {
              if (odds.length == 0 || (evens.length == 0 && k % 2 == 0)) {
                return 0;
              }
              if (k == a.length) {
                return (total % 2 == 0) ? 0 : (odds[0] + evenPrefixSums[evenPrefixSums.length - 1]);
              }

              int evenNum = Math.min(evens.length, k - 1);
              if (evenNum == evens.length && evenNum % 2 == k % 2) {
                --evenNum;
              }

              return odds[0] + evenPrefixSums[evenNum];
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}