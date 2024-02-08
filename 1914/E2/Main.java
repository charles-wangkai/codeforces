import java.util.Comparator;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> a[i] + b[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    long aScore = 0;
    long bScore = 0;
    for (int i = 0; i < sortedIndices.length; ++i) {
      if (i % 2 == 0) {
        aScore += a[sortedIndices[i]] - 1;
      } else {
        bScore += b[sortedIndices[i]] - 1;
      }
    }

    return aScore - bScore;
  }
}