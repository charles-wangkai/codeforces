import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] w = new int[2 * n];
    for (int i = 0; i < w.length; ++i) {
      w[i] = sc.nextInt();
    }

    System.out.println(solve(w));

    sc.close();
  }

  static int solve(int[] w) {
    Arrays.sort(w);

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < w.length; ++i) {
      for (int j = i + 1; j < w.length; ++j) {
        int i_ = i;
        int j_ = j;
        result =
            Math.min(
                result,
                computeInstability(
                    IntStream.range(0, w.length)
                        .filter(k -> k != i_ && k != j_)
                        .map(k -> w[k])
                        .toArray()));
      }
    }

    return result;
  }

  static int computeInstability(int[] a) {
    return IntStream.range(0, a.length / 2).map(i -> a[i * 2 + 1] - a[i * 2]).sum();
  }
}