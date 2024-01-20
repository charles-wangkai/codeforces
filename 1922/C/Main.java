import java.util.Scanner;
import java.util.stream.Collectors;
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
      int m = sc.nextInt();
      int[] x = new int[m];
      int[] y = new int[m];
      for (int i = 0; i < m; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static String solve(int[] a, int[] x, int[] y) {
    int n = a.length;

    boolean[] leftOrRightClosests = new boolean[n];
    for (int i = 0; i < leftOrRightClosests.length; ++i) {
      leftOrRightClosests[i] = i != 0 && (i == n - 1 || a[i] - a[i - 1] < a[i + 1] - a[i]);
    }

    int[] leftDistances = new int[n];
    for (int i = 1; i < leftDistances.length; ++i) {
      leftDistances[i] =
          leftDistances[i - 1] + (leftOrRightClosests[i - 1] ? (a[i] - a[i - 1]) : 1);
    }

    int[] rightDistances = new int[n];
    for (int i = rightDistances.length - 2; i >= 0; --i) {
      rightDistances[i] =
          rightDistances[i + 1] + (leftOrRightClosests[i + 1] ? 1 : (a[i + 1] - a[i]));
    }

    return IntStream.range(0, x.length)
        .map(
            i ->
                (x[i] < y[i])
                    ? (leftDistances[y[i] - 1] - leftDistances[x[i] - 1])
                    : (rightDistances[y[i] - 1] - rightDistances[x[i] - 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}