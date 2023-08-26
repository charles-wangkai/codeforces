import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    if (a[0] != a.length) {
      return false;
    }

    List<Integer> horizontal = new ArrayList<>();
    for (int i = a.length - 1; i >= 0; --i) {
      for (int j = 0; j < a[i] - ((i == a.length - 1) ? 0 : a[i + 1]); ++j) {
        horizontal.add(i + 1);
      }
    }

    return Arrays.equals(horizontal.stream().mapToInt(Integer::intValue).toArray(), a);
  }
}
