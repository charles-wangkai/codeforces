import java.util.Arrays;
import java.util.Scanner;
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

  static long solve(int[] a) {
    Arrays.sort(a);

    for (int i = a.length - 1; i >= 0; --i) {
      a[i] -= a[0];
    }

    int g = IntStream.range(1, a.length).map(i -> a[i]).reduce(Main::gcd).orElse(1);
    for (int i = 0; i < a.length; ++i) {
      a[i] /= g;
    }

    int index = a.length - 1;
    while (index != 0 && a[index - 1] == a[index] - 1) {
      --index;
    }

    int added = a[index] - 1;

    return IntStream.concat(IntStream.of(added), Arrays.stream(a))
        .map(x -> a[a.length - 1] - x)
        .asLongStream()
        .sum();
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}