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
    int n = a.length;

    int result = 0;
    int count = 1;
    while (true) {
      while (count < n && a[n - count - 1] == a[n - 1]) {
        ++count;
      }
      if (count >= n) {
        break;
      }

      ++result;
      count *= 2;
    }

    return result;
  }
}