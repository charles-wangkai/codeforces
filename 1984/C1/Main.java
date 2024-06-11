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

  static long solve(int[] a) {
    long min = 0;
    long max = 0;
    for (int ai : a) {
      long nextMin = Long.MAX_VALUE;
      long nextMax = Long.MIN_VALUE;
      for (long value : new long[] {min + ai, Math.abs(min + ai), max + ai, Math.abs(max + ai)}) {
        nextMin = Math.min(nextMin, value);
        nextMax = Math.max(nextMax, value);
      }

      min = nextMin;
      max = nextMax;
    }

    return max;
  }
}