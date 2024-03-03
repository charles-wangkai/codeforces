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
    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();

    int operationCount = 0;
    while (max != min) {
      max = (min + max) / 2;
      ++operationCount;
    }

    return (operationCount <= a.length)
        ? String.format(
            "%d\n%s",
            operationCount,
            IntStream.range(0, operationCount)
                .map(i -> min)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")))
        : String.valueOf(operationCount);
  }
}