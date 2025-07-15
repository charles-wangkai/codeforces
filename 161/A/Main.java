import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, x, y));

    sc.close();
  }

  static String solve(int[] a, int[] b, int x, int y) {
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

    List<String> pairs = new ArrayList<>();
    int bPos = 0;
    for (int aIndex : aSortedIndices) {
      while (bPos != bSortedIndices.length && b[bSortedIndices[bPos]] < a[aIndex] - x) {
        ++bPos;
      }

      if (bPos != bSortedIndices.length && b[bSortedIndices[bPos]] <= a[aIndex] + y) {
        pairs.add("%d %d".formatted(aIndex + 1, bSortedIndices[bPos] + 1));
        ++bPos;
      }
    }

    return "%d\n%s".formatted(pairs.size(), String.join("\n", pairs));
  }
}