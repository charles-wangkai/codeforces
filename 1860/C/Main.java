import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int result = 0;
    int min = Integer.MAX_VALUE;
    int luckyMin = Integer.MAX_VALUE;
    for (int pi : p) {
      if (pi < min) {
        min = pi;
      } else if (pi < luckyMin) {
        ++result;
        luckyMin = pi;
      }
    }

    return result;
  }
}
