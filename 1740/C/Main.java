import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    Arrays.sort(a);

    return Math.max(
        IntStream.range(1, a.length).map(i -> (a[i] - a[0]) + (a[i] - a[i - 1])).max().getAsInt(),
        IntStream.range(0, a.length - 1)
            .map(i -> (a[a.length - 1] - a[i]) + (a[i + 1] - a[i]))
            .max()
            .getAsInt());
  }
}