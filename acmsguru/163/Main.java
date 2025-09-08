import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int e = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, e));

    sc.close();
  }

  static int solve(int[] a, int e) {
    return Arrays.stream(a).map(ai -> Math.max(0, pow(ai, e))).sum();
  }

  static int pow(int base, int exponent) {
    return IntStream.range(0, exponent).reduce(1, (acc, x) -> acc * base);
  }
}