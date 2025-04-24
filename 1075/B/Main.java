import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] x = new int[n + m];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }
    int[] t = new int[n + m];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(n, m, x, t));

    sc.close();
  }

  static String solve(int n, int m, int[] x, int[] t) {
    int[] leftIndices = new int[n + m];
    int leftIndex = -1;
    for (int i = 0; i < leftIndices.length; ++i) {
      if (t[i] == 1) {
        leftIndex = i;
      } else {
        leftIndices[i] = leftIndex;
      }
    }

    int[] rightIndices = new int[n + m];
    int rightIndex = -1;
    for (int i = rightIndices.length - 1; i >= 0; --i) {
      if (t[i] == 1) {
        rightIndex = i;
      } else {
        rightIndices[i] = rightIndex;
      }
    }

    int[] counts = new int[n + m];
    for (int i = 0; i < t.length; ++i) {
      if (t[i] == 0) {
        int index =
            (rightIndices[i] == -1
                    || (leftIndices[i] != -1
                        && x[i] - x[leftIndices[i]] <= x[rightIndices[i]] - x[i]))
                ? leftIndices[i]
                : rightIndices[i];
        ++counts[index];
      }
    }

    return IntStream.range(0, counts.length)
        .filter(i -> t[i] == 1)
        .map(i -> counts[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}