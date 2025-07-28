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

    if (a[0] == a[a.length - 1]) {
      return a.length / 2;
    }

    return IntStream.range(1, a.length)
        .filter(i -> a[i] != a[i - 1])
        .mapToLong(i -> (long) i * (a.length - i))
        .max()
        .getAsLong();
  }
}