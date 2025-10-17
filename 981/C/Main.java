import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n - 1];
    int[] b = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int n = a.length + 1;

    int[] degrees = new int[n];
    for (int i = 0; i < a.length; ++i) {
      ++degrees[a[i] - 1];
      ++degrees[b[i] - 1];
    }

    int[] sortedIndices =
        IntStream.range(0, degrees.length)
            .boxed()
            .sorted(Comparator.comparing(i -> degrees[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    if (degrees[sortedIndices[sortedIndices.length - 2]] > 2) {
      return "No";
    }

    List<String> paths =
        (degrees[sortedIndices[sortedIndices.length - 1]] <= 2)
            ? List.of("%d %d".formatted(sortedIndices[0] + 1, sortedIndices[1] + 1))
            : IntStream.range(0, degrees.length)
                .filter(i -> degrees[i] == 1)
                .mapToObj(
                    i -> "%d %d".formatted(sortedIndices[sortedIndices.length - 1] + 1, i + 1))
                .toList();

    return "Yes\n%d\n%s".formatted(paths.size(), String.join("\n", paths));
  }
}