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
    if ((a.length == 3 && a[1] % 2 != 0)
        || IntStream.range(1, a.length - 1).allMatch(i -> a[i] == 1)) {
      return -1;
    }

    return IntStream.range(1, a.length - 1).map(i -> a[i] / 2 + a[i] % 2).asLongStream().sum();
  }
}