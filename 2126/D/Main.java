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
      int[] l = new int[n];
      int[] r = new int[n];
      int[] real = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
        real[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, real, k));
    }

    sc.close();
  }

  static int solve(int[] l, int[] r, int[] real, int k) {
    int[] sortedIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(Comparator.comparing(i -> l[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int result = k;
    for (int index : sortedIndices) {
      if (l[index] <= result) {
        result = Math.max(result, real[index]);
      }
    }

    return result;
  }
}