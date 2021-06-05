import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
    Map<Integer, Integer> valueToGreater =
        IntStream.range(0, sorted.length - 1)
            .filter(i -> sorted[i] != sorted[i + 1])
            .boxed()
            .collect(Collectors.toMap(i -> sorted[i], i -> sorted[i + 1]));

    Map<Integer, Long> valueToPrefixSum = new HashMap<>();
    long prefixSum = 0;
    for (int value : sorted) {
      prefixSum += value;
      valueToPrefixSum.put(value, prefixSum);
    }

    Set<Integer> possibleValues = new HashSet<>();
    possibleValues.add(sorted[sorted.length - 1]);
    for (int i = sorted.length - 1;
        i >= 0
            && (!valueToGreater.containsKey(sorted[i])
                || valueToPrefixSum.get(sorted[i]) >= valueToGreater.get(sorted[i]));
        --i) {
      possibleValues.add(sorted[i]);
    }

    int[] ids =
        IntStream.range(0, a.length)
            .filter(i -> possibleValues.contains(a[i]))
            .map(x -> x + 1)
            .toArray();

    return String.format(
        "%d\n%s",
        ids.length, Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
