import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    int[] maxValues = new int[k];
    for (int i = 0; i < a.length; ++i) {
      maxValues[i % k] = Math.max(maxValues[i % k], a[i]);
    }

    return Arrays.stream(maxValues).asLongStream().sum();
  }
}