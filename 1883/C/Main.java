import java.util.Arrays;
import java.util.Scanner;

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
    if (k != 4) {
      return Arrays.stream(a).map(ai -> (k - ai % k) % k).min().getAsInt();
    }

    if (Arrays.stream(a).reduce(1, (acc, x) -> multiplyMod(acc, x, 4)) == 0) {
      return 0;
    }
    if (Arrays.stream(a).anyMatch(ai -> ai % 4 == 3)
        || (Arrays.stream(a).anyMatch(ai -> ai % 2 == 0)
            && Arrays.stream(a).anyMatch(ai -> ai % 2 == 1))) {
      return 1;
    }
    if (Arrays.stream(a).anyMatch(ai -> ai % 2 == 0)
        || Arrays.stream(a).filter(ai -> ai % 2 == 1).count() >= 2) {
      return 2;
    }

    return 3;
  }

  static int multiplyMod(int x, int y, int m) {
    return Math.floorMod(x * y, m);
  }
}
