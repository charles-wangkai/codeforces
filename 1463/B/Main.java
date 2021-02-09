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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    long evenSum =
        IntStream.range(0, a.length).filter(i -> i % 2 == 0).map(i -> a[i]).asLongStream().sum();
    long oddSum = Arrays.stream(a).asLongStream().sum() - evenSum;

    int[] b;
    if (evenSum >= oddSum) {
      b = IntStream.range(0, a.length).map(i -> (i % 2 == 0) ? a[i] : 1).toArray();
    } else {
      b = IntStream.range(0, a.length).map(i -> (i % 2 == 0) ? 1 : a[i]).toArray();
    }

    return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
