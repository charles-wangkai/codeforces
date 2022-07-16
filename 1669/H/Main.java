import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    int[] counts = new int[31];
    for (int ai : a) {
      for (int i = 0; i < counts.length; ++i) {
        if ((ai & (1 << i)) == 0) {
          ++counts[i];
        }
      }
    }

    int result = 0;
    for (int i = counts.length - 1; i >= 0; --i) {
      if (k >= counts[i]) {
        result += 1 << i;
        k -= counts[i];
      }
    }

    return result;
  }
}