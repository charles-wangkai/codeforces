import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 30;

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
    int[][] counts = new int[BIT_NUM][2];
    for (int ai : a) {
      for (int b = 0; b < BIT_NUM; ++b) {
        ++counts[b][(ai >> b) & 1];
      }
    }

    return Arrays.stream(a)
        .mapToLong(
            ai ->
                IntStream.range(0, BIT_NUM)
                    .mapToLong(b -> (1L << b) * counts[b][1 - ((ai >> b) & 1)])
                    .sum())
        .max()
        .getAsLong();
  }
}