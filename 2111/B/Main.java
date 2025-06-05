import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] w = new int[m];
      int[] l = new int[m];
      int[] h = new int[m];
      for (int i = 0; i < m; ++i) {
        w[i] = sc.nextInt();
        l[i] = sc.nextInt();
        h[i] = sc.nextInt();
      }

      System.out.println(solve(n, w, l, h));
    }

    sc.close();
  }

  static String solve(int n, int[] w, int[] l, int[] h) {
    int[] f = new int[n];
    f[0] = 1;
    f[1] = 2;
    for (int i = 2; i < f.length; ++i) {
      f[i] = f[i - 2] + f[i - 1];
    }

    return IntStream.range(0, w.length)
        .map(i -> canFit(w[i], l[i], h[i], f[n - 1], f[n - 1], f[n - 1] + f[n - 2]) ? 1 : 0)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
  }

  static boolean canFit(int width, int length, int height, int side1, int side2, int side3) {
    int[] values = IntStream.of(width, length, height).sorted().toArray();

    return side1 <= values[0] && side2 <= values[1] && side3 <= values[2];
  }
}