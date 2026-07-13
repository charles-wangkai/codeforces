import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    if (n == 2) {
      return "-1";
    }

    long[] a = new long[n];
    long sum = 0;
    for (int i = 0; i < a.length; ++i) {
      a[i] = (i <= 1) ? (i + 1) : sum;

      sum += a[i];
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}