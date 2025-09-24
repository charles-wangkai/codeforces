import java.util.Arrays;
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

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    Arrays.sort(a);

    int[] indices =
        IntStream.range(0, a.length)
            .filter(i -> Math.max(0, Math.abs(i - (a.length - 1 - i)) - k) <= 1)
            .toArray();

    return a[indices[indices.length - 1]] - a[indices[0]] + 1;
  }
}