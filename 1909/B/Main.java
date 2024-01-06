import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(long[] a) {
    return LongStream.iterate(2, k -> k << 1)
        .filter(k -> Arrays.stream(a).map(ai -> ai % k).distinct().count() == 2)
        .findFirst()
        .getAsLong();
  }
}