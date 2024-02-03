import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int q = sc.nextInt();
      int[] l = new int[q];
      int[] k = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        k[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, k));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] k) {
    int n = a.length;

    int[][] nextZeroIndices = new int[BIT_NUM][n];
    for (int b = 0; b < BIT_NUM; ++b) {
      int nextZeroIndex = n;
      for (int i = n - 1; i >= 0; --i) {
        if (((a[i] >> b) & 1) == 0) {
          nextZeroIndex = i;
        }

        nextZeroIndices[b][i] = nextZeroIndex;
      }
    }

    return IntStream.range(0, l.length)
        .map(
            i -> {
              if (a[l[i] - 1] < k[i]) {
                return -1;
              }

              int freeIndex = -1;
              int minIndex = l[i] - 1;
              int maxIndex = n - 1;
              for (int b = BIT_NUM - 1; b >= 0 && minIndex <= maxIndex; --b) {
                if (((k[i] >> b) & 1) == 1) {
                  maxIndex = Math.min(maxIndex, nextZeroIndices[b][l[i] - 1] - 1);
                } else {
                  int tightBeginIndex = nextZeroIndices[b][l[i] - 1];
                  if (tightBeginIndex >= minIndex) {
                    freeIndex = Math.min(tightBeginIndex - 1, maxIndex);
                    minIndex = tightBeginIndex;
                  }
                }
              }

              return (minIndex <= maxIndex) ? (maxIndex + 1) : (freeIndex + 1);
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}