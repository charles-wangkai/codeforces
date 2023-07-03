import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    return (int)
        IntStream.range(0, a.length)
            .filter(i -> IntStream.range(0, a.length).allMatch(j -> j == i || b[j] != a[i]))
            .count();
  }
}
