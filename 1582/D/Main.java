import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    int[] b = new int[a.length];

    int beginIndex;
    if (a.length % 2 == 0) {
      beginIndex = 0;
    } else {
      if (Math.abs(a[0]) == Math.abs(a[1]) && Math.abs(a[1]) == Math.abs(a[2])) {
        b[0] = Integer.signum(a[0]);
        b[1] = Integer.signum(a[1]);
        b[2] = -2 * Integer.signum(a[2]);
      } else if (a[0] * a[1] < 0 && a[0] + a[1] != 0) {
        b[0] = a[2];
        b[1] = a[2];
        b[2] = -a[0] - a[1];
      } else if (a[0] * a[1] > 0 && a[0] - a[1] != 0) {
        b[0] = -a[2];
        b[1] = a[2];
        b[2] = a[0] - a[1];
      } else if (a[1] * a[2] < 0 && a[1] + a[2] != 0) {
        b[0] = -a[1] - a[2];
        b[1] = a[0];
        b[2] = a[0];
      } else if (a[1] * a[2] > 0 && a[1] - a[2] != 0) {
        b[0] = a[1] - a[2];
        b[1] = -a[0];
        b[2] = a[0];
      } else if (a[2] * a[0] < 0 && a[2] + a[0] != 0) {
        b[0] = a[1];
        b[1] = -a[2] - a[0];
        b[2] = a[1];
      } else {
        b[0] = a[1];
        b[1] = a[2] - a[0];
        b[2] = -a[1];
      }

      beginIndex = 3;
    }

    for (int i = beginIndex; i < a.length; i += 2) {
      b[i] = a[i + 1];
      b[i + 1] = -a[i];
    }

    return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}