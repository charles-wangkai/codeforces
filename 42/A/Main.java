import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int V = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(a, b, V)));

    sc.close();
  }

  static double solve(int[] a, int[] b, int V) {
    int sumA = Arrays.stream(a).sum();

    return Math.min(
        V,
        IntStream.range(0, a.length)
            .mapToDouble(i -> (double) b[i] * sumA / a[i])
            .min()
            .getAsDouble());
  }
}