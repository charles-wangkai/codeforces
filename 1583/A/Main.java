import java.util.Arrays;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int sum = Arrays.stream(a).sum();
    if (isComposite(sum)) {
      return String.format(
          "%d\n%s",
          a.length,
          IntStream.range(0, a.length)
              .mapToObj(i -> String.valueOf(i + 1))
              .collect(Collectors.joining(" ")));
    }
    for (int i = 0; ; ++i) {
      if (a[i] % 2 != 0) {
        int i_ = i;
        return String.format(
            "%d\n%s",
            a.length - 1,
            IntStream.range(0, a.length)
                .filter(x -> x != i_)
                .mapToObj(x -> String.valueOf(x + 1))
                .collect(Collectors.joining(" ")));
      }
    }
  }

  static boolean isComposite(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return true;
      }
    }

    return false;
  }
}
