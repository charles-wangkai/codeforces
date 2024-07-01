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
    int result = h[h.length - 1];
    for (int i = h.length - 2; i >= 0; --i) {
      result = Math.max(h[i], result + 1);
    }

    return result;
  }
}