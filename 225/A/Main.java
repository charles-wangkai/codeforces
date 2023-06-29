import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(x, a, b) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int x, int[] a, int[] b) {
    return IntStream.range(0, a.length)
            .mapToObj(
                i -> {
                  int value1 = Math.min(7 - a[i], a[i]);
                  int value2 = Math.min(7 - b[i], b[i]);

                  return new Pair(Math.min(value1, value2), Math.max(value1, value2));
                })
            .distinct()
            .count()
        == 1;
  }
}

record Pair(int p, int q) {}
