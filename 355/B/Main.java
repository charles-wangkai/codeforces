import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int c1 = sc.nextInt();
    int c2 = sc.nextInt();
    int c3 = sc.nextInt();
    int c4 = sc.nextInt();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(c1, c2, c3, c4, a, b));

    sc.close();
  }

  static int solve(int c1, int c2, int c3, int c4, int[] a, int[] b) {
    return Math.min(c4, computeCost(c1, c2, c3, a) + computeCost(c1, c2, c3, b));
  }

  static int computeCost(int c1, int c2, int c3, int[] times) {
    return Math.min(c3, Arrays.stream(times).map(time -> Math.min(c2, c1 * time)).sum());
  }
}