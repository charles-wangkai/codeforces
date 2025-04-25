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
      int x = sc.nextInt();

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static String solve(int n, int x) {
    int[] result = IntStream.range(0, n).toArray();
    for (int i = x, j = result.length - 1; i < j; ++i, --j) {
      int temp = result[i];
      result[i] = result[j];
      result[j] = temp;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}