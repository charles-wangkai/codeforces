import java.util.Scanner;
import java.util.stream.LongStream;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    long minScore = 0;
    long maxScore = 0;
    for (int i = 0; i < a.length; ++i) {
      int i_ = i;
      long[] sorted =
          LongStream.of(minScore, maxScore)
              .flatMap(score -> LongStream.of(score - a[i_], b[i_] - score))
              .sorted()
              .toArray();

      minScore = sorted[0];
      maxScore = sorted[sorted.length - 1];
    }

    return maxScore;
  }
}