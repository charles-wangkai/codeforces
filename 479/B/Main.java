import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static String solve(int[] a, int k) {
    List<String> operations = new ArrayList<>();
    for (int i = 0; i < k; ++i) {
      int minIndex =
          IntStream.range(0, a.length).boxed().min(Comparator.comparing(j -> a[j])).get();
      int maxIndex =
          IntStream.range(0, a.length).boxed().max(Comparator.comparing(j -> a[j])).get();
      if (a[minIndex] == a[maxIndex]) {
        break;
      }

      --a[maxIndex];
      ++a[minIndex];
      operations.add("%d %d".formatted(maxIndex + 1, minIndex + 1));
    }

    return "%d %d\n%s"
        .formatted(
            Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt(),
            operations.size(),
            String.join("\n", operations));
  }
}