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
    int result = 0;
    int length = 0;
    for (int i = 1; i < a.length; ++i) {
      if (a[i - 1] < a[i] * 2) {
        ++length;
        if (length >= k) {
          ++result;
        }
      } else {
        length = 0;
      }
    }

    return result;
  }
}