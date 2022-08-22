import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int b = sc.nextInt();
      long s = sc.nextLong();

      System.out.println(solve(n, k, b, s));
    }

    sc.close();
  }

  static String solve(int n, int k, int b, long s) {
    long rest = s - (long) k * b;
    if (rest < 0 || rest > n * (k - 1L)) {
      return "-1";
    }

    long[] a = new long[n];
    a[0] = (long) k * b;
    for (int i = 0; i < a.length; ++i) {
      a[i] += rest / n + ((i < rest % n) ? 1 : 0);
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}