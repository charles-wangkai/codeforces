import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c));
    }

    sc.close();
  }

  static int solve(int[] a, int c) {
    int result = a.length;
    boolean[] destroyed = new boolean[a.length];
    while (true) {
      Optional<Integer> index =
          IntStream.range(0, destroyed.length)
              .filter(i -> !destroyed[i] && a[i] <= c)
              .boxed()
              .max(Comparator.comparing(i -> a[i]));
      if (index.isEmpty()) {
        break;
      }

      destroyed[index.get()] = true;

      for (int i = 0; i < destroyed.length; ++i) {
        if (a[i] <= c) {
          a[i] *= 2;
        }
      }

      --result;
    }

    return result;
  }
}