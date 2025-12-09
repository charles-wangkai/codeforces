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
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, m));

    sc.close();
  }

  static int solve(int[] a, int[] b, int m) {
    Arrays.sort(b);

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < b.length; ++i) {
      int x = Math.floorMod(b[i] - a[0], m);
      if (Arrays.equals(Arrays.stream(a).map(ai -> (ai + x) % m).sorted().toArray(), b)) {
        result = Math.min(result, x);
      }
    }

    return result;
  }
}