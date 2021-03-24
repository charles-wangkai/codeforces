import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < q; ++i) {
      int l = sc.nextInt() - 1;
      int r = sc.nextInt() - 1;

      System.out.println(solve(a, k, l, r));
    }

    sc.close();
  }

  static int solve(int[] a, int k, int l, int r) {
    int total = k - (r - l + 1);
    int boundary = (a[l] - 1) + (k - a[r]);

    return boundary + (total - boundary) * 2;
  }
}
