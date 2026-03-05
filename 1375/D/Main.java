import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    List<Integer> operations = new ArrayList<>();

    while (IntStream.range(0, a.length - 1).anyMatch(i -> a[i] > a[i + 1])) {
      int m = mex(a);
      int index =
          (m == a.length)
              ? IntStream.range(0, a.length).filter(i -> a[i] != i).findAny().getAsInt()
              : m;

      a[index] = m;
      operations.add(index);
    }

    return "%d\n%s"
        .formatted(
            operations.size(),
            operations.stream()
                .map(operation -> operation + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
  }

  static int mex(int[] a) {
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    for (int i = 0; ; ++i) {
      if (!set.contains(i)) {
        return i;
      }
    }
  }
}