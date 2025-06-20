import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    int[] c = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b, c));

    sc.close();
  }

  static int solve(int n, int[] a, int[] b, int[] c) {
    int[] balances = new int[n];
    for (int i = 0; i < a.length; ++i) {
      balances[a[i] - 1] -= c[i];
      balances[b[i] - 1] += c[i];
    }

    return Arrays.stream(balances).map(balance -> Math.max(0, balance)).sum();
  }
}