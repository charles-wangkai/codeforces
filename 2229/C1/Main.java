import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    List<Integer> indices = new ArrayList<>();
    OptionalInt lastIndex = IntStream.range(0, a.length).filter(i -> a[i] > 0).max();
    if (lastIndex.isPresent()) {
      indices.add(lastIndex.getAsInt());
      for (int i = lastIndex.getAsInt() - 1; i >= 0; --i) {
        if (Integer.signum(a[i]) != Integer.signum(a[i + 1])) {
          indices.add(i);
        }
      }
    }

    return "%d\n%s"
        .formatted(
            indices.size(),
            indices.stream()
                .map(index -> index + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}