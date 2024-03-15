import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 1_000_000_000;

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
      int[] x = new int[q];
      long[] y = new long[q];
      for (int i = 0; i < q; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextLong();
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static String solve(int[] a, int[] x, long[] y) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return IntStream.range(0, x.length)
        .mapToLong(
            i -> {
              int part1 = findOnePart(x[i], y[i]);
              if (part1 == Integer.MIN_VALUE) {
                return 0;
              }

              int part2 = x[i] - part1;

              return (part1 == part2)
                  ? ((long) valueToCount.getOrDefault(part1, 0)
                      * (valueToCount.getOrDefault(part1, 0) - 1)
                      / 2)
                  : ((long) valueToCount.getOrDefault(part1, 0)
                      * (valueToCount.getOrDefault(part2, 0)));
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int findOnePart(int sum, long product) {
    if (product < 0) {
      if (sum < 0) {
        int lower = -LIMIT;
        int upper = sum - 1;
        while (lower <= upper) {
          int middle = (lower + upper) / 2;
          long p = (long) middle * (sum - middle);
          if (p == product) {
            return middle;
          }

          if (p < product) {
            lower = middle + 1;
          } else {
            upper = middle - 1;
          }
        }
      } else {
        int lower = sum + 1;
        int upper = LIMIT;
        while (lower <= upper) {
          int middle = (lower + upper) / 2;
          long p = (long) middle * (sum - middle);
          if (p == product) {
            return middle;
          }

          if (p < product) {
            upper = middle - 1;
          } else {
            lower = middle + 1;
          }
        }
      }
    } else if (sum < 0) {
      int lower = sum / 2;
      int upper = -1;
      while (lower <= upper) {
        int middle = (lower + upper) / 2;
        long p = (long) middle * (sum - middle);
        if (p == product) {
          return middle;
        }

        if (p < product) {
          upper = middle - 1;
        } else {
          lower = middle + 1;
        }
      }
    } else {
      int lower = 1;
      int upper = sum / 2;
      while (lower <= upper) {
        int middle = (lower + upper) / 2;
        long p = (long) middle * (sum - middle);
        if (p == product) {
          return middle;
        }

        if (p < product) {
          lower = middle + 1;
        } else {
          upper = middle - 1;
        }
      }
    }

    return Integer.MIN_VALUE;
  }
}