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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int result = 0;
    Set<Integer> seen = new HashSet<>();
    seen.add(0);
    int xor = 0;
    for (int ai : a) {
      xor ^= ai;

      for (int x : seen) {
        result = Math.max(result, xor ^ x);
      }

      seen.add(xor);
    }

    return result;
  }
}
