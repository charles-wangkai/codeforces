import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] p = new int[k];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(a, p));
    }

    sc.close();
  }

  static int solve(int[] a, int[] p) {
    return Math.max(
        computeOperationNum(reverse(IntStream.rangeClosed(0, p[0] - 1).map(i -> a[i]).toArray())),
        computeOperationNum(IntStream.range(p[0] - 1, a.length).map(i -> a[i]).toArray()));
  }

  static int[] reverse(int[] values) {
    return IntStream.range(0, values.length).map(i -> values[values.length - 1 - i]).toArray();
  }

  static int computeOperationNum(int[] values) {
    int diffCount =
        (int) IntStream.range(1, values.length).filter(i -> values[i] != values[i - 1]).count();

    return diffCount + diffCount % 2;
  }
}