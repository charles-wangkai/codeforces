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
      int[] times = new int[n];
      for (int i = 0; i < times.length; ++i) {
        times[i] = sc.nextInt();
      }

      System.out.println(String.format("%.9f", solve(x, times)));
    }

    sc.close();
  }

  static double solve(int[] x, int[] times) {
    return (IntStream.range(0, x.length).map(i -> x[i] - times[i]).min().getAsInt()
            + IntStream.range(0, x.length).map(i -> x[i] + times[i]).max().getAsInt())
        / 2.0;
  }
}
