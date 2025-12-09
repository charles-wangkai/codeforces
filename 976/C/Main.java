import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] l = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(l, r));

    sc.close();
  }

  static String solve(int[] l, int[] r) {
    int[] sortedIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> l[i])
                    .thenComparing(Comparator.<Integer, Integer>comparing(i -> r[i]).reversed()))
            .mapToInt(Integer::intValue)
            .toArray();
    OptionalInt index =
        IntStream.range(0, sortedIndices.length - 1)
            .filter(i -> r[sortedIndices[i]] >= r[sortedIndices[i + 1]])
            .findAny();

    return index.isPresent()
        ? "%d %d"
            .formatted(sortedIndices[index.getAsInt() + 1] + 1, sortedIndices[index.getAsInt()] + 1)
        : "-1 -1";
  }
}