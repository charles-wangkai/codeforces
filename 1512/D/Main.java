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
      int[] b = new int[n + 2];
      ;
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    Map<Integer, Set<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < b.length; ++i) {
      if (!valueToIndices.containsKey(b[i])) {
        valueToIndices.put(b[i], new HashSet<>());
      }
      valueToIndices.get(b[i]).add(i);
    }

    long total = Arrays.stream(b).asLongStream().sum();
    for (int i = 0; i < b.length; ++i) {
      valueToIndices.get(b[i]).remove(i);

      if ((total - b[i]) % 2 == 0 && (total - b[i]) / 2 <= Integer.MAX_VALUE) {
        int sum = (int) ((total - b[i]) / 2);

        if (valueToIndices.containsKey(sum) && !valueToIndices.get(sum).isEmpty()) {
          int sumIndex = valueToIndices.get(sum).iterator().next();

          int i_ = i;
          return IntStream.range(0, b.length)
              .filter(j -> j != i_ && j != sumIndex)
              .mapToObj(j -> String.valueOf(b[j]))
              .collect(Collectors.joining(" "));
        }
      }

      valueToIndices.get(b[i]).add(i);
    }

    return "-1";
  }
}
