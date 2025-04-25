import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int k) {
    OptionalInt index = IntStream.range(0, b.length).filter(i -> b[i] != -1).findAny();
    if (index.isPresent()) {
      int sum = a[index.getAsInt()] + b[index.getAsInt()];

      return IntStream.range(0, a.length)
              .allMatch(
                  i -> {
                    if (b[i] == -1) {
                      int target = sum - a[i];

                      return target >= 0 && target <= k;
                    }

                    return a[i] + b[i] == sum;
                  })
          ? 1
          : 0;
    }

    return k - (Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt()) + 1;
  }
}