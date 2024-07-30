import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int[] a) {
    return (Arrays.stream(a).map(ai -> ai % 2).distinct().count() == 1)
        ? "%d\n%s"
            .formatted(
                BIT_NUM + 1,
                IntStream.range(0, BIT_NUM + 1)
                    .map(i -> (i == BIT_NUM) ? (1 - (a[0] % 2)) : (1 << (BIT_NUM - 1 - i)))
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        : "-1";
  }
}