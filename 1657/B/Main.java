import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int B = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(n, B, x, y));
    }

    sc.close();
  }

  static long solve(int n, int B, int x, int y) {
    int[] a = new int[n + 1];
    for (int i = 1; i < a.length; ++i) {
      if (a[i - 1] + x <= B) {
        a[i] = a[i - 1] + x;
      } else {
        a[i] = a[i - 1] - y;
      }
    }

    return Arrays.stream(a).asLongStream().sum();
  }
}