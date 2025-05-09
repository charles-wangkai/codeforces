import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int c = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c));

    sc.close();
  }

  static String solve(int[] a, int[] b, int c) {
    int[] prefixSums = new int[b.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = addMod((i == 0) ? 0 : prefixSums[i - 1], b[i], c);
    }

    return IntStream.range(0, a.length)
        .map(
            i ->
                addMod(
                    a[i],
                    computeRangeSum(
                        c,
                        prefixSums,
                        Math.max(0, i - (a.length - b.length)),
                        Math.min(b.length - 1, i)),
                    c))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int computeRangeSum(int c, int[] prefixSums, int beginIndex, int endIndex) {
    return addMod(prefixSums[endIndex], (beginIndex == 0) ? 0 : -prefixSums[beginIndex - 1], c);
  }

  static int addMod(int x, int y, int m) {
    return Math.floorMod(x + y, m);
  }
}