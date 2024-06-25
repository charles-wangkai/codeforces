import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, x) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] a, int x) {
    return Arrays.stream(a).sum() + a.length - 1 == x;
  }
}