import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int BIT_NUM = 20;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    int[] values = new int[a.length];
    for (int i = 0; i < BIT_NUM; ++i) {
      int i_ = i;
      int[] sorted = Arrays.stream(a).map(x -> x & (1 << i_)).sorted().toArray();
      for (int j = 0; j < values.length; ++j) {
        values[j] += sorted[j];
      }
    }

    return Arrays.stream(values).mapToLong(x -> (long) x * x).sum();
  }
}
