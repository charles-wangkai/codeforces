import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h));
    }

    sc.close();
  }

  static int solve(int[] h) {
    int result = -1;
    int lower = 0;
    int upper = h[h.length - 1];
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(h, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] h, int target) {
    long[] stones = Arrays.stream(h).asLongStream().toArray();
    for (int i = stones.length - 1; i >= 2; --i) {
      int extra = (int) Math.min(h[i], Math.max(0, stones[i] - target));

      stones[i - 1] += extra / 3;
      stones[i - 2] += extra / 3 * 2;
    }

    return Arrays.stream(stones).allMatch(stone -> stone >= target);
  }
}
