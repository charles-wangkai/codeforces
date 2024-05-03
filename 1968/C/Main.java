import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 500;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n - 1];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int[] x) {
    int[] a = new int[x.length + 1];
    a[0] = LIMIT + 1;
    for (int i = 1; i < a.length; ++i) {
      a[i] = a[i - 1] + x[i - 1];
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}