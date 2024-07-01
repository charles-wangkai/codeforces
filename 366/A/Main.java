import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[4];
    int[] b = new int[4];
    int[] c = new int[4];
    int[] d = new int[4];
    for (int i = 0; i < 4; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b, c, d));

    sc.close();
  }

  static String solve(int n, int[] a, int[] b, int[] c, int[] d) {
    for (int cost1 = 1; cost1 < n; ++cost1) {
      int cost2 = n - cost1;
      for (int i = 0; i < a.length; ++i) {
        if (cost1 >= Math.min(a[i], b[i]) && cost2 >= Math.min(c[i], d[i])) {
          return "%d %d %d".formatted(i + 1, cost1, cost2);
        }
      }
    }

    return "-1";
  }
}