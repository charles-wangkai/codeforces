import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] n = new int[q];
      for (int i = 0; i < n.length; ++i) {
        n[i] = sc.nextInt();
      }

      System.out.println(solve(a, n));
    }

    sc.close();
  }

  static String solve(int[] a, int[] n) {
    return Arrays.stream(n)
        .map(ni -> Math.min(ni, a[0] - 1))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}