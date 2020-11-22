import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n * k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, k, a));
    }

    sc.close();
  }

  static long solve(int n, int k, int[] a) {
    long result = 0;
    int index = a.length - 1 - n / 2;
    for (int i = 0; i < k; ++i) {
      result += a[index];
      index -= 1 + n / 2;
    }

    return result;
  }
}
