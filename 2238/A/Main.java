import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int c) {
    int extra;
    if (IntStream.range(0, a.length).allMatch(i -> a[i] >= b[i])) {
      extra = 0;
    } else {
      Arrays.sort(a);
      Arrays.sort(b);

      if (IntStream.range(0, a.length).allMatch(i -> a[i] >= b[i])) {
        extra = c;
      } else {
        return -1;
      }
    }

    return Arrays.stream(a).sum() - Arrays.stream(b).sum() + extra;
  }
}