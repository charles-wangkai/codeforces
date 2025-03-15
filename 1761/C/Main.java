import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] b = new int[n][n];
      for (int i = 0; i < n; ++i) {
        String line = sc.next();
        for (int j = 0; j < n; ++j) {
          b[i][j] = line.charAt(j) - '0';
        }
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[][] b) {
    int n = b.length;

    int[] rowSums = Arrays.stream(b).mapToInt(line -> Arrays.stream(line).sum()).toArray();
    int[] sortedIndices =
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> rowSums[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    @SuppressWarnings("unchecked")
    Set<Integer>[] sets = new Set[n];
    for (int i = 0; i < sets.length; ++i) {
      sets[i] = new HashSet<>();
    }

    for (int i = 0; i < sortedIndices.length; ++i) {
      sets[sortedIndices[i]].add(i + 1);

      for (int j = 0; j < n; ++j) {
        if (b[sortedIndices[i]][j] == 1) {
          sets[j].addAll(sets[sortedIndices[i]]);
        }
      }
    }

    return Arrays.stream(sets)
        .map(
            set ->
                "%d %s"
                    .formatted(
                        set.size(),
                        set.stream().map(String::valueOf).collect(Collectors.joining(" "))))
        .collect(Collectors.joining("\n"));
  }
}