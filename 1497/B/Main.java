import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static int solve(int[] a, int m) {
    int[] counts = new int[m];
    for (int ai : a) {
      ++counts[ai % m];
    }

    int result = 0;
    for (int i = 0; i * 2 <= m; ++i) {
      int other = (m - i) % m;
      if (other == i) {
        if (counts[i] != 0) {
          ++result;
        }
      } else {
        int min = Math.min(counts[i], counts[other]);
        int max = Math.max(counts[i], counts[other]);

        if (max != 0) {
          result += Math.max(0, max - min - 1) + 1;
        }
      }
    }

    return result;
  }
}
