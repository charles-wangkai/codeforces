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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int delta =
        Math.abs(
            (int) Arrays.stream(a).filter(x -> x == 0).count()
                - (int) Arrays.stream(b).filter(x -> x == 0).count());
    int diffCount = (int) IntStream.range(0, a.length).filter(i -> a[i] != b[i]).count();

    return delta + ((diffCount == delta) ? 0 : 1);
  }
}
