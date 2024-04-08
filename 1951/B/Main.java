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
    int largerIndex = 0;
    while (largerIndex != a.length && a[largerIndex] <= a[k - 1]) {
      ++largerIndex;
    }

    if (largerIndex == a.length) {
      return a.length - 1;
    }
    if (largerIndex > k - 1) {
      return largerIndex - 1;
    }

    int temp = a[largerIndex];
    a[largerIndex] = a[k - 1];
    a[k - 1] = temp;

    int winCount = (largerIndex == 0) ? 0 : 1;
    for (int i = largerIndex + 1; i < a.length && a[largerIndex] > a[i]; ++i) {
      ++winCount;
    }

    return Math.max(winCount, largerIndex - 1);
  }
}