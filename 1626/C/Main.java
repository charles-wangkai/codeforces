import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] k = new int[n];
      for (int i = 0; i < k.length; ++i) {
        k[i] = sc.nextInt();
      }
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(k, h));
    }

    sc.close();
  }

  static long solve(int[] k, int[] h) {
    int n = k.length;

    int[] lowers =
        IntStream.range(0, n)
            .map(i -> IntStream.range(i, n).map(j -> h[j] - (k[j] - k[i])).max().getAsInt())
            .toArray();

    int[] damages = new int[n];
    for (int i = 0; i < damages.length; ++i) {
      damages[i] =
          (i == 0 || lowers[i] <= k[i] - k[i - 1])
              ? lowers[i]
              : (damages[i - 1] + (k[i] - k[i - 1]));
    }

    long result = 0;
    for (int i = 0; i < damages.length; ++i) {
      if (i == 0 || damages[i] <= k[i] - k[i - 1]) {
        result += damages[i] * (damages[i] + 1L) / 2;
      } else {
        result += (damages[i - 1] + 1L + damages[i]) * (k[i] - k[i - 1]) / 2;
      }
    }

    return result;
  }
}
