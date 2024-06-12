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
    int result = 0;
    long sum = 0;
    int max = Integer.MIN_VALUE;
    for (int ai : a) {
      sum += ai;
      max = Math.max(max, ai);

      if (sum == max * 2) {
        ++result;
      }
    }

    return result;
  }
}