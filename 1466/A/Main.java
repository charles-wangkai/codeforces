import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int[] x) {
    return (int)
        IntStream.range(0, x.length)
            .flatMap(i -> IntStream.range(i + 1, x.length).map(j -> x[j] - x[i]))
            .distinct()
            .count();
  }
}
