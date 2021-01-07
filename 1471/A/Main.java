import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static String solve(int[] a, int x) {
    return String.format(
        "%d %d",
        (Arrays.stream(a).asLongStream().sum() + x - 1) / x,
        Arrays.stream(a).map(ai -> (ai + x - 1) / x).asLongStream().sum());
  }
}
