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
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, x));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int x) {
    int[] aSortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    int[] bSortedIndices =
        IntStream.range(0, b.length)
            .boxed()
            .sorted(Comparator.comparing(i -> b[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] rearranged = new int[b.length];
    for (int i = 0; i < aSortedIndices.length; ++i) {
      rearranged[aSortedIndices[i]] = b[bSortedIndices[(i + x) % bSortedIndices.length]];
    }

    return (IntStream.range(0, a.length).filter(i -> a[i] > rearranged[i]).count() == x)
        ? "YES\n%s"
            .formatted(
                Arrays.stream(rearranged)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        : "NO";
  }
}