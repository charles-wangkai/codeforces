import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int[] sorted = Arrays.stream(a).sorted().toArray();
    Map<Integer, Integer> valueToTargetIndex =
        IntStream.range(0, sorted.length).boxed().collect(Collectors.toMap(i -> sorted[i], i -> i));

    List<List<Integer>> subsequences = new ArrayList<>();
    boolean[] visited = new boolean[a.length];
    for (int i = 0; i < visited.length; ++i) {
      if (!visited[i]) {
        List<Integer> subsequence = new ArrayList<>();
        search(subsequence, a, valueToTargetIndex, visited, i);

        subsequences.add(subsequence);
      }
    }

    return "%d\n%s"
        .formatted(
            subsequences.size(),
            subsequences.stream()
                .map(
                    subsequence ->
                        "%d %s"
                            .formatted(
                                subsequence.size(),
                                subsequence.stream()
                                    .map(index -> index + 1)
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(" "))))
                .collect(Collectors.joining("\n")));
  }

  static void search(
      List<Integer> subsequence,
      int[] a,
      Map<Integer, Integer> valueToTargetIndex,
      boolean[] visited,
      int index) {
    if (!visited[index]) {
      visited[index] = true;
      subsequence.add(index);

      search(subsequence, a, valueToTargetIndex, visited, valueToTargetIndex.get(a[index]));
    }
  }
}