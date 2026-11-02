import java.util.Map;
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
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i));

    int length = a.length + 1 - k;

    OptionalInt freeIndex = IntStream.range(0, length).filter(i -> a[i] >= length).findAny();
    if (freeIndex.isEmpty()) {
      return "-1";
    }

    for (int value = 0; ; ++value) {
      if (valueToIndex.get(value) >= length) {
        return "%d %d".formatted(freeIndex.getAsInt() + 1, valueToIndex.get(value) + 1);
      }
    }
  }
}