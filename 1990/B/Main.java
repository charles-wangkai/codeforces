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
      int y = sc.nextInt();

      System.out.println(solve(n, x, y));
    }

    sc.close();
  }

  static String solve(int n, int x, int y) {
    int[] result = new int[n];
    for (int i = y - 1; i <= x - 1; ++i) {
      result[i] = 1;
    }
    for (int i = y - 2; i >= 0; --i) {
      result[i] = ((y - 2 - i) % 2 == 0) ? -1 : 1;
    }
    for (int i = x; i < result.length; ++i) {
      result[i] = ((i - x) % 2 == 0) ? -1 : 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}