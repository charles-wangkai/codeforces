import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 1; tc <= t; ++tc) {
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
    int n = a.length;

    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();

    int[] extremeIndices = IntStream.range(0, n).filter(i -> a[i] == min || a[i] == max).toArray();

    return Math.min(
        Math.min(extremeIndices[1] + 1, n - extremeIndices[0]),
        extremeIndices[0] + 1 + n - extremeIndices[1]);
  }
}
