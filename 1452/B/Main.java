import java.util.Arrays;
import java.util.Scanner;

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

  static long solve(int[] a) {
    int n = a.length;

    int max = Arrays.stream(a).max().getAsInt();

    long result = max * (n - 1L) - Arrays.stream(a).asLongStream().sum();
    if (result < 0) {
      result = (result % (n - 1) + (n - 1)) % (n - 1);
    }

    return result;
  }
}
