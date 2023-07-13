import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static long solve(int[] c) {
    if (c.length == 1) {
      return c[0];
    }

    return Math.max(
        computeMaxSubSequenceSum(
            IntStream.range(0, c.length).filter(i -> i % 2 == 0).map(i -> c[i]).toArray()),
        computeMaxSubSequenceSum(
            IntStream.range(0, c.length).filter(i -> i % 2 == 1).map(i -> c[i]).toArray()));
  }

  static long computeMaxSubSequenceSum(int[] values) {
    int[] nonNegatives = Arrays.stream(values).filter(x -> x >= 0).toArray();

    return (nonNegatives.length == 0)
        ? Arrays.stream(values).max().getAsInt()
        : Arrays.stream(nonNegatives).asLongStream().sum();
  }
}
