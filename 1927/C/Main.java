import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int k) {
    Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());
    Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());

    int onlyA = 0;
    int onlyB = 0;
    int common = 0;
    for (int i = 1; i <= k; ++i) {
      if (aSet.contains(i)) {
        if (bSet.contains(i)) {
          ++common;
        } else {
          ++onlyA;
        }
      } else if (bSet.contains(i)) {
        ++onlyB;
      } else {
        return false;
      }
    }

    return Math.min(onlyA, onlyB) + common >= k / 2;
  }
}