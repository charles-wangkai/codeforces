import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h, k));
    }

    sc.close();
  }

  static int solve(int[] h, int k) {
    for (int i = 0; ; ++i) {
      int index = 0;
      while (index != h.length && (index == h.length - 1 || h[index] >= h[index + 1])) {
        ++index;
      }

      if (index == h.length) {
        return -1;
      }
      if (i == k - 1) {
        return index + 1;
      }

      ++h[index];
    }
  }
}
