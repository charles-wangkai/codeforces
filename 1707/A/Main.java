import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, q));
    }

    sc.close();
  }

  static String solve(int[] a, int q) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(
                (i1, i2) -> {
                  boolean le1 = a[i1] <= q;
                  boolean le2 = a[i2] <= q;
                  int indexCmp = Integer.compare(i1, i2);
                  if (le1) {
                    if (le2) {
                      return indexCmp;
                    } else {
                      return -1;
                    }
                  } else {
                    if (le2) {
                      return 1;
                    } else {
                      return -indexCmp;
                    }
                  }
                })
            .mapToInt(x -> x)
            .toArray();

    String result = "0".repeat(a.length);
    int lower = 1;
    int upper = a.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      boolean[] chosen = new boolean[a.length];
      for (int i = 0; i < middle; ++i) {
        chosen[sortedIndices[i]] = true;
      }

      if (check(a, q, chosen)) {
        result =
            IntStream.range(0, chosen.length)
                .mapToObj(i -> chosen[i] ? "1" : "0")
                .collect(Collectors.joining());
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int q, boolean[] chosen) {
    for (int i = 0; i < a.length; ++i) {
      if (chosen[i]) {
        if (q == 0) {
          return false;
        }

        if (a[i] > q) {
          --q;
        }
      }
    }

    return true;
  }
}
