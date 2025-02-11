import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    int[] jumpedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> a[i] - (a.length - 1 - i)).reversed())
            .limit(k)
            .mapToInt(Integer::intValue)
            .toArray();

    boolean[] jumped = new boolean[a.length];
    for (int jumpedIndex : jumpedIndices) {
      jumped[jumpedIndex] = true;
    }

    long result = 0;
    int jumpedCount = 0;
    for (int i = 0; i < jumped.length; ++i) {
      if (jumped[i]) {
        ++jumpedCount;
      } else {
        result += a[i] + jumpedCount;
      }
    }

    return result;
  }
}