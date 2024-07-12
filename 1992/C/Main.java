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
      int m = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, m, k));
    }

    sc.close();
  }

  static String solve(int n, int m, int k) {
    int[] result = IntStream.range(0, n).map(i -> n - i).toArray();
    for (int i = result.length - m, j = result.length - 1; i < j; ++i, --j) {
      int temp = result[i];
      result[i] = result[j];
      result[j] = temp;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}