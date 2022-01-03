import java.util.Arrays;
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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
      if (a[i] != a[j]) {
        int i_ = i;
        int j_ = j;
        return isPalindrome(Arrays.stream(a).filter(x -> x != a[i_]).toArray())
            || isPalindrome(Arrays.stream(a).filter(x -> x != a[j_]).toArray());
      }
    }

    return true;
  }

  static boolean isPalindrome(int[] x) {
    for (int i = 0, j = x.length - 1; i < j; ++i, --j) {
      if (x[i] != x[j]) {
        return false;
      }
    }

    return true;
  }
}
