import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(A, B, a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int A, int B, int[] a, int[] b) {
    return IntStream.range(0, a.length).mapToLong(i -> (b[i] + A - 1L) / A * a[i]).sum()
            - Arrays.stream(a).max().getAsInt()
        < B;
  }
}
