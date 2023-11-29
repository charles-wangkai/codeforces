import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static long solve(int[] c) {
    return IntStream.range(0, c.length)
            .map(i -> Math.max(0, c[i] - ((i == 0) ? 0 : c[i - 1])))
            .asLongStream()
            .sum()
        - 1;
  }
}