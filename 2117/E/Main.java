import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    Set<Integer> seen = new HashSet<>();
    for (int i = a.length - 1; i >= 0; --i) {
      if (a[i] == b[i]) {
        return i + 1;
      }
      if (i != a.length - 1) {
        if (a[i] == a[i + 1] || b[i] == b[i + 1] || seen.contains(a[i]) || seen.contains(b[i])) {
          return i + 1;
        }

        seen.add(a[i + 1]);
        seen.add(b[i + 1]);
      }
    }

    return 0;
  }
}