import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      String instructions = sc.next();

      System.out.println(solve(a, b, instructions));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, String instructions) {
    int[] minOffsets = new int[instructions.length()];
    int[] maxOffsets = new int[instructions.length()];
    int offset = 0;
    for (int i = 0; i < instructions.length(); ++i) {
      offset += (instructions.charAt(i) == 'L') ? -1 : 1;

      minOffsets[i] = Math.min((i == 0) ? 0 : minOffsets[i - 1], offset);
      maxOffsets[i] = Math.max((i == 0) ? 0 : maxOffsets[i - 1], offset);
    }

    NavigableSet<Integer> spikes = new TreeSet<>(Arrays.stream(b).boxed().toList());

    int[] deadCounts = new int[instructions.length()];
    for (int ai : a) {
      int deadIndex = findDeadIndex(minOffsets, maxOffsets, spikes, ai);
      if (deadIndex != -1) {
        ++deadCounts[deadIndex];
      }
    }

    int[] result = new int[instructions.length()];
    for (int i = 0; i < result.length; ++i) {
      result[i] = ((i == 0) ? a.length : result[i - 1]) - deadCounts[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int findDeadIndex(
      int[] minOffsets, int[] maxOffsets, NavigableSet<Integer> spikes, int robot) {
    Integer leftSpike = spikes.lower(robot);
    int leftDistance = (leftSpike == null) ? Integer.MAX_VALUE : (robot - leftSpike);

    Integer rightSpike = spikes.higher(robot);
    int rightDistance = (rightSpike == null) ? Integer.MAX_VALUE : (rightSpike - robot);

    int result = -1;
    int lower = 0;
    int upper = minOffsets.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (-minOffsets[middle] >= leftDistance || maxOffsets[middle] >= rightDistance) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}