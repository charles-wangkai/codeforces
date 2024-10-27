import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] w = new int[n];
      int[] h = new int[n];
      for (int i = 0; i < n; ++i) {
        w[i] = sc.nextInt();
        h[i] = sc.nextInt();
      }

      System.out.println(solve(w, h));
    }

    sc.close();
  }

  static int solve(int[] w, int[] h) {
    return (Arrays.stream(w).max().getAsInt() + Arrays.stream(h).max().getAsInt()) * 2;
  }
}