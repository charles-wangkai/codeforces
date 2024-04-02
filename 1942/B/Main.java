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
    int n = a.length;

    int[] p = new int[n];
    int mex = n;
    for (int i = p.length - 1; i >= 0; --i) {
      p[i] = mex - a[i];
      mex = Math.min(mex, p[i]);
    }

    return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}