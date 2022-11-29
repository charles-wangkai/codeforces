// https://codeforces.com/blog/entry/104930

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, q));
    }

    sc.close();
  }

  static String solve(int[] a, int q) {
    boolean[] chosen = new boolean[a.length];
    int current = 0;
    for (int i = chosen.length - 1; i >= 0; --i) {
      if (a[i] <= current) {
        chosen[i] = true;
      } else if (current != q) {
        chosen[i] = true;
        ++current;
      }
    }

    return IntStream.range(0, chosen.length)
        .mapToObj(i -> chosen[i] ? "1" : "0")
        .collect(Collectors.joining());
  }
}
