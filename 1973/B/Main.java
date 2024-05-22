import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 20;

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

  static int solve(int[] a) {
    int result = -1;
    int lower = 1;
    int upper = a.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int k) {
    return IntStream.range(0, BIT_NUM)
        .allMatch(
            b -> {
              int[] prefixSums = new int[a.length + 1];
              for (int i = 1; i < prefixSums.length; ++i) {
                prefixSums[i] = prefixSums[i - 1] + ((a[i - 1] >> b) & 1);
              }

              return IntStream.range(0, prefixSums.length - k)
                      .mapToObj(i -> prefixSums[i + k] - prefixSums[i] == 0)
                      .distinct()
                      .count()
                  == 1;
            });
  }
}