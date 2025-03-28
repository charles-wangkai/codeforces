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
      int[] b = new int[2 * n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    Arrays.sort(b);

    long[] result = new long[b.length + 1];
    int evenIndex = 0;
    int oddIndex = 1;

    result[evenIndex] = b[b.length - 1];
    evenIndex += 2;

    result[evenIndex] = b[b.length - 2];
    evenIndex += 2;

    for (int i = b.length - 3; i >= 0; i -= 2) {
      result[evenIndex] = b[i];
      evenIndex += 2;

      result[oddIndex] = b[i - 1];
      oddIndex += 2;
    }

    result[oddIndex] =
        IntStream.range(0, result.length).mapToLong(i -> ((i % 2 == 0) ? 1 : -1) * result[i]).sum();

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}