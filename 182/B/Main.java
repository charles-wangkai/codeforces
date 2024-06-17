import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int d = sc.nextInt();
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(d, a));

    sc.close();
  }

  static int solve(int d, int[] a) {
    return IntStream.range(1, a.length).map(i -> (1 - (a[i - 1] % d + 1) + d) % d).sum();
  }
}