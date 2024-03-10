import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] l = new int[q];
    int[] r = new int[q];
    for (int i = 0; i < q; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(a, l, r));

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] r) {
    int n = a.length;

    int[] counts = new int[n];
    Arrays.fill(counts, -1);
    int count = 0;
    for (int i = 0; i < n; ++i) {
      if (i == 0 || i == n - 1 || a[i] > a[i - 1] || a[i] < a[i + 1]) {
        counts[i] = count;
        ++count;
      }
    }

    int[] leftIndices = new int[n];
    int leftIndex = -1;
    for (int i = 0; i < leftIndices.length; ++i) {
      if (counts[i] != -1) {
        leftIndex = i;
      }
      leftIndices[i] = leftIndex;
    }

    int[] rightIndices = new int[n];
    int rightIndex = -1;
    for (int i = rightIndices.length - 1; i >= 0; --i) {
      if (counts[i] != -1) {
        rightIndex = i;
      }
      rightIndices[i] = rightIndex;
    }

    return IntStream.range(0, l.length)
        .map(
            i ->
                (l[i] == r[i])
                    ? 1
                    : (counts[rightIndices[r[i] - 1]] - counts[leftIndices[l[i] - 1]] + 1))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}