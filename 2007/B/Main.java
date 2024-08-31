import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String[] c = new String[m];
      int[] l = new int[m];
      int[] r = new int[m];
      for (int i = 0; i < m; ++i) {
        c[i] = sc.next();
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, c, l, r));
    }

    sc.close();
  }

  static String solve(int[] a, String[] c, int[] l, int[] r) {
    int[] result = new int[c.length];
    int max = Arrays.stream(a).max().getAsInt();
    for (int i = 0; i < result.length; ++i) {
      if (max >= l[i] && max <= r[i]) {
        if (c[i].equals("+")) {
          ++max;
        } else {
          --max;
        }
      }

      result[i] = max;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}