import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int d = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y, d, a, b));

    sc.close();
  }

  static String solve(int[] x, int[] y, int d, int a, int b) {
    int[] memories = IntStream.range(0, x.length).map(i -> x[i] * a + y[i] * b).toArray();
    int[] sortedIndices =
        IntStream.range(0, memories.length)
            .boxed()
            .sorted(Comparator.comparing(i -> memories[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    List<Integer> served = new ArrayList<>();
    for (int index : sortedIndices) {
      if (memories[index] > d) {
        break;
      }

      served.add(index);
      d -= memories[index];
    }

    return "%d\n%s"
        .formatted(
            served.size(),
            served.stream()
                .map(index -> index + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}