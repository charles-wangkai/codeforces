import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YA" : "TIDAK");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    Set<Integer> frees = new HashSet<>();
    int index = 0;
    for (int bi : b) {
      if (!frees.contains(bi)) {
        if (bi != a[index]) {
          return false;
        }

        frees.add(a[index]);
        ++index;
      }
    }

    return true;
  }
}