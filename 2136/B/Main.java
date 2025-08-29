import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static String solve(String s, int k) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        count = 0;
      } else {
        ++count;
      }

      if (count >= k) {
        return "NO";
      }
    }

    int[] sortedIndices =
        IntStream.range(0, s.length())
            .boxed()
            .sorted(Comparator.comparing(s::charAt).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int[] permutation = new int[s.length()];
    for (int i = 0; i < sortedIndices.length; ++i) {
      permutation[sortedIndices[i]] = i + 1;
    }

    return "YES\n%s"
        .formatted(
            Arrays.stream(permutation).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}