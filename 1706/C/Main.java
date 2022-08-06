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

  static long solve(int[] h) {
    int[] needed = new int[h.length];
    for (int i = 1; i < needed.length - 1; ++i) {
      needed[i] = Math.max(0, Math.max(h[i - 1], h[i + 1]) + 1 - h[i]);
    }

    long rightSum = 0;
    for (int i = needed.length - 2; i >= 1; i -= 2) {
      rightSum += needed[i];
    }

    long result = rightSum;
    if (h.length % 2 == 0) {
      long leftSum = 0;
      for (int i = 1; i <= needed.length - 3; i += 2) {
        leftSum += needed[i];
        rightSum -= needed[i + 1];
        result = Math.min(result, leftSum + rightSum);
      }
    }

    return result;
  }
}