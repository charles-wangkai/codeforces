import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[k];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] d = new int[q];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, d));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] d) {
    int[] positions = IntStream.concat(IntStream.of(0), Arrays.stream(a)).toArray();
    int[] times = IntStream.concat(IntStream.of(0), Arrays.stream(b)).toArray();

    return Arrays.stream(d)
        .map(
            di -> {
              int index = findIndex(positions, di);

              return (di == positions[index])
                  ? times[index]
                  : (times[index]
                      + (int)
                          ((long) (di - positions[index])
                              * (times[index + 1] - times[index])
                              / (positions[index + 1] - positions[index])));
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int findIndex(int[] positions, int target) {
    int result = -1;
    int lower = 0;
    int upper = positions.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (positions[middle] <= target) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}