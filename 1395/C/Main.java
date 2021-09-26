import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    for (int result = 0; ; ++result) {
      if (check(a, b, result)) {
        return result;
      }
    }
  }

  static boolean check(int[] a, int[] b, int xorResult) {
    return Arrays.stream(a)
        .allMatch(ai -> Arrays.stream(b).anyMatch(bi -> (xorResult | (ai & bi)) == xorResult));
  }
}
