import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(int[] a) {
    return IntStream.range(0, a.length)
        .boxed()
        .sorted(Comparator.comparing(i -> (i == 0) ? Integer.MIN_VALUE : (a[i - 1] - a[i])))
        .mapToInt(x -> x + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}
