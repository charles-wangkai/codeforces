import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int n = sc.nextInt();
    int[] low = new int[n];
    int[] high = new int[n];
    for (int i = 0; i < n; ++i) {
      low[i] = sc.nextInt();
      high[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, low, high));

    sc.close();
  }

  static String solve(int a, int b, int[] low, int[] high) {
    int g = gcd(a, b);
    List<Integer> divisors = new ArrayList<>();
    for (int i = 1; i * i <= g; ++i) {
      if (g % i == 0) {
        divisors.add(i);
        if (i * i != g) {
          divisors.add(g / i);
        }
      }
    }
    Collections.sort(divisors);

    return IntStream.range(0, low.length)
        .map(
            i -> {
              int index = Collections.binarySearch(divisors, high[i]);
              if (index < 0) {
                index = -index - 2;
              }

              return (index >= 0 && divisors.get(index) >= low[i]) ? divisors.get(index) : -1;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
