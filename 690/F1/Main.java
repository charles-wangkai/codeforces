import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n - 1];
    int[] b = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int n = a.length + 1;

    int[] degrees = new int[n];
    for (int i = 0; i < a.length; ++i) {
      ++degrees[a[i] - 1];
      ++degrees[b[i] - 1];
    }

    return Arrays.stream(degrees).map(degree -> degree * (degree - 1) / 2).asLongStream().sum();
  }
}