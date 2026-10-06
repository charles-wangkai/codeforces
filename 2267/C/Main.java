import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static long solve(int[] a, int x) {
    return buildPrimes(x).stream()
        .mapToLong(prime -> Arrays.stream(a).filter(ai -> ai % prime == 0).asLongStream().sum())
        .max()
        .orElse(0);
  }

  static List<Integer> buildPrimes(int x) {
    List<Integer> result = new ArrayList<>();
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        result.add(i);

        while (x % i == 0) {
          x /= i;
        }
      }
    }
    if (x != 1) {
      result.add(x);
    }

    return result;
  }
}