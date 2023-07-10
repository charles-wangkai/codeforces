import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, m, a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int n, int m, int[] a) {
    return check(a, n, m) || check(a, m, n);
  }

  static boolean check(int[] a, int height, int width) {
    return Arrays.stream(a)
            .map(ai -> ai / height)
            .filter(w -> w >= 2)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .limit(width / 2)
            .mapToInt(Integer::intValue)
            .asLongStream()
            .sum()
        >= width;
  }
}
