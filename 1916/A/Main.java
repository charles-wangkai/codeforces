import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int TARGET = 2023;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b, k));
    }

    sc.close();
  }

  static String solve(int[] b, int k) {
    long product = Arrays.stream(b).asLongStream().reduce((acc, x) -> acc * x).getAsLong();
    if (TARGET % product != 0) {
      return "NO";
    }

    return "YES\n%s"
        .formatted(
            IntStream.range(0, k)
                .map(i -> (i == 0) ? (int) (TARGET / product) : 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}