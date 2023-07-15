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
    long[] values = Arrays.stream(a).asLongStream().toArray();

    long result = 0;
    long subtracted = 0;
    for (int i = values.length - 2; i >= 0; --i) {
      values[i] -= subtracted;
      if (values[i] > values[i + 1]) {
        result += values[i] - values[i + 1];
        subtracted += values[i] - values[i + 1];
        values[i] = values[i + 1];
      }
    }

    result += values[values.length - 1] - values[0];
    result += Math.abs(values[0]);

    return result;
  }
}
