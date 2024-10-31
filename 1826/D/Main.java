import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static int solve(int[] b) {
    int n = b.length;

    int[] leftMaxs = new int[n];
    int leftMax = Integer.MIN_VALUE;
    for (int i = 0; i < leftMaxs.length; ++i) {
      leftMaxs[i] = leftMax;
      leftMax = Math.max(leftMax, b[i] + i);
    }

    int[] rightMaxs = new int[n];
    int rightMax = Integer.MIN_VALUE;
    for (int i = rightMaxs.length - 1; i >= 0; --i) {
      rightMaxs[i] = rightMax;
      rightMax = Math.max(rightMax, b[i] - i);
    }

    return IntStream.range(1, n - 1).map(i -> leftMaxs[i] + b[i] + rightMaxs[i]).max().getAsInt();
  }
}