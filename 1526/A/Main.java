import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[2 * n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    Arrays.sort(a);

    return IntStream.range(0, a.length)
        .mapToObj(i -> String.valueOf((i % 2 == 0) ? a[i / 2] : a[a.length / 2 + i / 2]))
        .collect(Collectors.joining(" "));
  }
}
