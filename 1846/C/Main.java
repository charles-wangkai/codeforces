import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int h = sc.nextInt();
      int[][] times = new int[n][m];
      for (int i = 0; i < times.length; ++i) {
        for (int j = 0; j < times[i].length; ++j) {
          times[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(times, h));
    }

    sc.close();
  }

  static int solve(int[][] times, int h) {
    Outcome firstOutcome = computeBestOutcome(h, times[0]);

    return (int)
            IntStream.range(1, times.length)
                .mapToObj(i -> computeBestOutcome(h, times[i]))
                .filter(
                    outcome ->
                        Comparator.comparing(Outcome::point)
                                .reversed()
                                .thenComparing(Outcome::penalty)
                                .compare(outcome, firstOutcome)
                            < 0)
                .count()
        + 1;
  }

  static Outcome computeBestOutcome(int h, int[] time) {
    Arrays.sort(time);

    long[] prefixSums = new long[time.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + time[i];
    }

    return new Outcome(
        (int) Arrays.stream(prefixSums).filter(prefixSum -> prefixSum <= h).count(),
        Arrays.stream(prefixSums).filter(prefixSum -> prefixSum <= h).sum());
  }
}

record Outcome(int point, long penalty) {}
