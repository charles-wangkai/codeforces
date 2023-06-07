import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k, q));
    }

    sc.close();
  }

  static long solve(int[] a, int k, int q) {
    long result = 0;
    int count = 0;
    for (int i = 0; i <= a.length; ++i) {
      if (i != a.length && a[i] <= q) {
        ++count;
      } else {
        int length = count - k + 1;
        if (length >= 1) {
          result += length * (length + 1L) / 2;
        }

        count = 0;
      }
    }

    return result;
  }
}
