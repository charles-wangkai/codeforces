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

      System.out.println(String.format("! %d", solve(sc, a)));
      System.out.flush();
    }

    sc.close();
  }

  static int solve(Scanner sc, int[] a) {
    int[] prefixSums = new int[a.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + a[i - 1];
    }

    int lower = 1;
    int upper = a.length;
    while (lower < upper) {
      int middle = (lower + upper) / 2;
      if (query(sc, lower, middle) == prefixSums[middle] - prefixSums[lower - 1]) {
        lower = middle + 1;
      } else {
        upper = middle;
      }
    }

    return lower;
  }

  static int query(Scanner sc, int begin, int end) {
    System.out.println(
        String.format(
            "? %d %s",
            end - begin + 1,
            IntStream.rangeClosed(begin, end)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))));
    System.out.flush();

    return sc.nextInt();
  }
}
