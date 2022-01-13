import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x, l));
    }

    sc.close();
  }

  static int solve(int[] x, int l) {
    int result = 0;
    for (int i = 0; i < l; ++i) {
      int[] counts = new int[2];
      for (int xi : x) {
        ++counts[Integer.signum(xi & (1 << i))];
      }
      if (counts[1] > counts[0]) {
        result += 1 << i;
      }
    }

    return result;
  }
}
