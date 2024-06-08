import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] h = new int[n];
    for (int i = 0; i < h.length; ++i) {
      h[i] = sc.nextInt();
    }

    System.out.println(solve(h, a, b));

    sc.close();
  }

  static int solve(int[] h, int a, int b) {
    Arrays.sort(h);

    return h[b] - h[b - 1];
  }
}