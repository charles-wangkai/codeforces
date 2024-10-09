import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int x) {
    int[] counts = new int[a.length + 1];
    for (int ai : a) {
      if (ai < counts.length) {
        ++counts[ai];
      }
    }

    int result = 0;
    while (counts[result] != 0) {
      if (result + x < counts.length) {
        counts[result + x] += counts[result] - 1;
      }

      ++result;
    }

    return result;
  }
}