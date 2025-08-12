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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    int beginIndex = 0;
    while (beginIndex != a.length) {
      if (a[beginIndex] == b[beginIndex]) {
        ++beginIndex;
      } else {
        int endIndex = beginIndex;
        int xor = a[endIndex];
        while (xor != b[beginIndex]) {
          if (endIndex == a.length - 1) {
            return false;
          }

          ++endIndex;
          xor ^= a[endIndex];
        }

        for (int i = beginIndex; i + 1 < endIndex; ++i) {
          xor ^= a[i];
          if (xor != b[i + 1]) {
            return false;
          }
        }

        beginIndex = endIndex;
      }
    }

    return true;
  }
}