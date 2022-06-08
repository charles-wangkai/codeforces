import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }
      int[] f = new int[n];
      for (int i = 0; i < f.length; ++i) {
        f[i] = sc.nextInt();
      }

      System.out.println(solve(s, f));
    }

    sc.close();
  }

  static String solve(int[] s, int[] f) {
    int[] d = new int[s.length];
    for (int i = 0; i < d.length; ++i) {
      d[i] = f[i] - Math.max(s[i], (i == 0) ? -1 : f[i - 1]);
    }

    return Arrays.stream(d).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}