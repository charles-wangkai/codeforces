import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int[] leftIndices = new int[b.length];
    int leftIndex = 0;
    for (int i = 0; i < leftIndices.length; ++i) {
      while (leftIndex < a.length && a[leftIndex] < b[i]) {
        ++leftIndex;
      }

      leftIndices[i] = leftIndex;
      ++leftIndex;
    }

    int[] rightIndices = new int[b.length];
    int rightIndex = a.length - 1;
    for (int i = rightIndices.length - 1; i >= 0; --i) {
      while (rightIndex >= 0 && a[rightIndex] < b[i]) {
        --rightIndex;
      }

      rightIndices[i] = rightIndex;
      --rightIndex;
    }

    if (leftIndices[leftIndices.length - 1] < a.length) {
      return 0;
    }

    return IntStream.range(0, b.length)
        .filter(
            i -> {
              if (i == 0) {
                return b.length == 1 || rightIndices[1] >= 0;
              }
              if (i == b.length - 1) {
                return leftIndices[i - 1] < a.length;
              }

              return leftIndices[i - 1] < rightIndices[i + 1];
            })
        .map(i -> b[i])
        .min()
        .orElse(-1);
  }
}