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

  static int solve(int[] a) {
    long[] values = Arrays.stream(a).asLongStream().toArray();
    long sum = 0;
    for (int i = values.length - 1; i >= 0; --i) {
      values[i] += sum;
      sum = Math.max(0, values[i]);
    }

    return (int) Arrays.stream(values).filter(x -> x > 0).count();
  }
}