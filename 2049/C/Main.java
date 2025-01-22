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
    if (n % 2 == 0) {
      for (int i = 1; i < result.length; i += 2) {
        result[i] = 1;
      }
      if (x % 2 == y % 2) {
        result[x - 1] = 2;
      }
    } else {
      result[x - 1] = 2;
      for (int i = 1; i < n; ++i) {
        result[(x - 1 + i) % result.length] = i % 2;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}