import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n * (n - 1) / 2];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(n, b));
    }

    sc.close();
  }

  static String solve(int n, int[] b) {
    Arrays.sort(b);

    int[] result = new int[n];
    int bIndex = 0;
    for (int i = 0; i < result.length - 1; ++i) {
      result[i] = b[bIndex];
      bIndex += n - 1 - i;
    }
    result[result.length - 1] = b[b.length - 1];

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
