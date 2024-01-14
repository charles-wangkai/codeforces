import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] x = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int[] x) {
    int min = IntStream.range(0, a.length).filter(i -> a[i] == 1).map(i -> x[i]).max().getAsInt();
    int max = IntStream.range(0, a.length).filter(i -> a[i] == 2).map(i -> x[i]).min().getAsInt();

    return Math.max(0, max - min + 1)
        - (int)
            IntStream.range(0, a.length)
                .filter(i -> a[i] == 3)
                .filter(i -> x[i] >= min && x[i] <= max)
                .count();
  }
}