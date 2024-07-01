import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] l = new int[m];
    int[] r = new int[m];
    for (int i = 0; i < m; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(a, l, r));

    sc.close();
  }

  static int solve(int[] a, int[] l, int[] r) {
    int time = Arrays.stream(a).sum();
    for (int i = 0; i < l.length; ++i) {
      if (r[i] >= time) {
        return Math.max(time, l[i]);
      }
    }

    return -1;
  }
}