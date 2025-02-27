import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    int[] result = new int[n];
    Arrays.fill(result, x);
    for (int i = 0; i < result.length && (i | x) == x; ++i) {
      result[i] = i;
    }

    if (Arrays.stream(result).reduce((acc, y) -> acc | y).getAsInt() != x) {
      result[result.length - 1] = x;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}