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
    int last = Integer.MAX_VALUE;
    for (int i = a.length - 1; i >= 0; --i) {
      if (a[i] <= last) {
        last = a[i];
      } else {
        int length = (a[i] + last - 1) / last;
        result += length - 1;
        last = a[i] / length;
      }
    }

    return result;
  }
}