import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    int n = a.length;

    a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

    long result = Arrays.stream(a).mapToLong(x -> x - 1).sum();
    for (int base = 2; ; ++base) {
      long limit = a[n - 1] + result;

      boolean possible = true;
      long[] powers = new long[n];
      long power = 1;
      for (int i = 0; i < powers.length; ++i) {
        if (power >= limit) {
          possible = false;

          break;
        }

        powers[i] = power;

        power *= base;
      }
      if (!possible) {
        break;
      }

      int[] a_ = a;
      result =
          Math.min(result, IntStream.range(0, n).mapToLong(i -> Math.abs(a_[i] - powers[i])).sum());
    }

    return result;
  }
}
