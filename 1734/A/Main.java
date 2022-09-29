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
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; ++i) {
      for (int j = i + 1; j < a.length; ++j) {
        for (int k = j + 1; k < a.length; ++k) {
          result =
              Math.min(
                  result,
                  Math.min(
                      Math.min(
                          Math.abs(a[j] - a[i]) + Math.abs(a[k] - a[i]),
                          Math.abs(a[k] - a[j]) + Math.abs(a[i] - a[j])),
                      Math.abs(a[i] - a[k]) + Math.abs(a[j] - a[k])));
        }
      }
    }

    return result;
  }
}
