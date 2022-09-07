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
    if (a.length == 1) {
      return 0;
    }

    return Math.max(
        Math.max(
            a[a.length - 1] - IntStream.range(0, a.length - 1).map(i -> a[i]).min().getAsInt(),
            IntStream.range(1, a.length).map(i -> a[i]).max().getAsInt() - a[0]),
        IntStream.range(0, a.length)
            .map(i -> a[(i + a.length - 1) % a.length] - a[i])
            .max()
            .getAsInt());
  }
}