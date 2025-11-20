import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int x = sc.nextInt();
    int f = sc.nextInt();

    System.out.println(solve(a, x, f));

    sc.close();
  }

  static long solve(int[] a, int x, int f) {
    return Arrays.stream(a)
        .map(ai -> Math.ceilDiv(Math.max(0, ai - x), x + f) * f)
        .asLongStream()
        .sum();
  }
}