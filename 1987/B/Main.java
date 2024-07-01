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
    long result = 0;
    int max = -1;
    int maxDiff = 0;
    for (int ai : a) {
      max = Math.max(max, ai);
      int diff = max - ai;
      maxDiff = Math.max(maxDiff, diff);
      result += diff;
    }
    result += maxDiff;

    return result;
  }
}