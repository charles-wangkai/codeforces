import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int LIMIT = 20;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int W = sc.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }

      System.out.println(solve(w, W));
    }

    sc.close();
  }

  static int solve(int[] w, int W) {
    int[] counts = new int[LIMIT + 1];
    for (int wi : w) {
      ++counts[Integer.numberOfTrailingZeros(wi)];
    }

    int result = 0;
    while (Arrays.stream(counts).anyMatch(count -> count != 0)) {
      int remain = W;
      for (int i = counts.length - 1; i >= 0; --i) {
        while (remain >= 1 << i && counts[i] != 0) {
          remain -= 1 << i;
          --counts[i];
        }
      }

      ++result;
    }

    return result;
  }
}
