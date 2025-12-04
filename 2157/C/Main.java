import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int q = sc.nextInt();
      int[] c = new int[q];
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        c[i] = sc.nextInt();
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(n, k, c, l, r));
    }

    sc.close();
  }

  static String solve(int n, int k, int[] c, int[] l, int[] r) {
    boolean[] minInvolved = new boolean[n];
    boolean[] mexInvolved = new boolean[n];
    for (int i = 0; i < c.length; ++i) {
      for (int j = l[i] - 1; j <= r[i] - 1; ++j) {
        ((c[i] == 1) ? minInvolved : mexInvolved)[j] = true;
      }
    }

    int[] result = new int[n];
    int value = 0;
    for (int i = 0; i < result.length; ++i) {
      if (minInvolved[i]) {
        if (mexInvolved[i]) {
          result[i] = k + 1;
        } else {
          result[i] = k;
        }
      } else if (mexInvolved[i]) {
        result[i] = value;
        value = (value + 1) % k;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}