import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r, k));
    }

    sc.close();
  }

  static int solve(int[] a, int l, int r, int k) {
    int[] sorted = Arrays.stream(a).filter(ai -> ai >= l && ai <= r).sorted().toArray();

    int result = 0;
    for (int price : sorted) {
      if (price <= k) {
        k -= price;
        ++result;
      }
    }

    return result;
  }
}
