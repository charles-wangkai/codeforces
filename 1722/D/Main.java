import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String line = sc.next();

      System.out.println(solve(line));
    }

    sc.close();
  }

  static String solve(String line) {
    long value = 0;
    int[] deltas = new int[line.length()];
    for (int i = 0; i < line.length(); ++i) {
      int leftCount = i;
      int rightCount = line.length() - 1 - i;
      if (line.charAt(i) == 'L') {
        value += leftCount;
        deltas[i] = Math.max(0, rightCount - leftCount);
      } else {
        value += rightCount;
        deltas[i] = Math.max(0, leftCount - rightCount);
      }
    }

    int[] sortedDeltas =
        Arrays.stream(deltas).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

    long[] result = new long[line.length()];
    for (int i = 0; i < result.length; ++i) {
      result[i] = ((i == 0) ? value : result[i - 1]) + sortedDeltas[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}