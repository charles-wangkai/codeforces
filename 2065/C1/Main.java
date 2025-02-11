import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    int prev = Integer.MIN_VALUE;
    for (int ai : a) {
      int prev_ = prev;
      OptionalInt value = IntStream.of(ai, b[0] - ai).filter(x -> x >= prev_).min();
      if (value.isEmpty()) {
        return false;
      }

      prev = value.getAsInt();
    }

    return true;
  }
}