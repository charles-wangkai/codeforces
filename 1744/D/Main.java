import java.util.Arrays;
import java.util.Comparator;
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

  static int solve(int[] a) {
    int result = 0;
    int rest = a.length - Arrays.stream(a).map(Main::computeTwoExponent).sum();
    int[] sortedExtras =
        IntStream.rangeClosed(1, a.length)
            .map(Main::computeTwoExponent)
            .filter(x -> x != 0)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();
    for (int extra : sortedExtras) {
      if (rest >= 1) {
        ++result;
        rest -= extra;
      }
    }

    return (rest <= 0) ? result : -1;
  }

  static int computeTwoExponent(int x) {
    int result = 0;
    while (x % 2 == 0) {
      ++result;
      x /= 2;
    }

    return result;
  }
}
