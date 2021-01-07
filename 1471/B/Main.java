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

  static long solve(int[] a, int x) {
    long result = Arrays.stream(a).asLongStream().sum();
    int[] rests = Arrays.copyOf(a, a.length);
    int index = 0;
    while (rests[index] % x == 0) {
      result += a[index];
      rests[index] /= x;

      index = (index + 1) % a.length;
    }

    return result;
  }
}
