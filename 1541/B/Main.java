import java.util.Map;
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

  static int solve(int[] a) {
    int n = a.length;

    Map<Integer, Integer> valueToId =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i + 1));

    int result = 0;
    for (int product = 2; product < 2 * n; ++product) {
      for (int i = 1; i * i < product; ++i) {
        if (product % i == 0) {
          Integer id1 = valueToId.get(i);
          Integer id2 = valueToId.get(product / i);
          if (id1 != null && id2 != null && id1 + id2 == product) {
            ++result;
          }
        }
      }
    }

    return result;
  }
}
