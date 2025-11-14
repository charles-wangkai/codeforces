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
    int firstHeight =
        IntStream.rangeClosed(1, Arrays.stream(a).max().getAsInt())
            .boxed()
            .min(Comparator.comparing(first -> computeDiffNum(a, k, first)))
            .get();

    List<String> actions = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      int target = firstHeight + i * k;
      if (a[i] < target) {
        actions.add("+ %d %d".formatted(i + 1, target - a[i]));
      } else if (a[i] > target) {
        actions.add("- %d %d".formatted(i + 1, a[i] - target));
      }
    }

    return "%d\n%s".formatted(actions.size(), String.join("\n", actions));
  }

  static int computeDiffNum(int[] a, int k, int firstHeight) {
    return (int) IntStream.range(0, a.length).filter(i -> a[i] != firstHeight + i * k).count();
  }
}