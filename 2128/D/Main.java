import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static long solve(int[] p) {
    return IntStream.rangeClosed(1, p.length).mapToLong(i -> i * (p.length + 1L - i)).sum()
        - IntStream.range(0, p.length - 1)
            .filter(i -> p[i] < p[i + 1])
            .mapToLong(i -> (i + 1L) * (p.length - i - 1))
            .sum();
  }
}