import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    if (Arrays.stream(a).reduce((x, y) -> x & y).getAsInt() != 0) {
      return 1;
    }

    int result = 0;
    int and = -1;
    for (int ai : a) {
      and = (and == -1) ? ai : (and & ai);
      if (and == 0) {
        ++result;
        and = -1;
      }
    }

    return result;
  }
}
