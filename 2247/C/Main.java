import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int n = a.length;

    if (IntStream.range(0, n).allMatch(i -> a[i] == b[i])) {
      return 0;
    }
    if (Arrays.stream(a).allMatch(ai -> ai == 0) || Arrays.stream(b).allMatch(bi -> bi == 1)) {
      return -1;
    }

    return (IntStream.range(0, n).filter(i -> a[i] == 1 && b[i] == 0).count() % 2 == 1) ? 1 : 2;
  }
}