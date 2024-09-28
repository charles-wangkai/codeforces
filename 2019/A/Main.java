import java.util.Arrays;
import java.util.Scanner;
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

  static int solve(int[] a) {
    return Math.max(
        computeScore(IntStream.range(0, a.length).filter(i -> i % 2 == 0).map(i -> a[i]).toArray()),
        computeScore(
            IntStream.range(0, a.length).filter(i -> i % 2 == 1).map(i -> a[i]).toArray()));
  }

  static int computeScore(int[] values) {
    return Arrays.stream(values).max().orElse(0) + values.length;
  }
}