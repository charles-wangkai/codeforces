import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int[] result = new int[4 * n];
    if (n == 2) {
      result[0] = 1;
      result[1] = 2;
      result[2] = 2;
      result[3] = 1;
      result[4] = 2;
      result[5] = 1;
      result[6] = 1;
      result[7] = 2;
    } else {
      for (int i = 0; i < n; ++i) {
        result[2 * i] = i + 1;
        result[2 * i + 1] = i + 1;
      }

      for (int i = 0; i < n / 2; ++i) {
        result[2 * n + i * 4] = 2 * i + 1;
        result[2 * n + i * 4 + 1] = 2 * i + 2;
        result[2 * n + i * 4 + 2] = 2 * i + 1;
        result[2 * n + i * 4 + 3] = 2 * i + 2;
      }

      if (n % 2 == 1) {
        result[result.length - 2] = n;
        result[result.length - 1] = n;

        int temp = result[result.length - 2];
        result[result.length - 2] = result[result.length - 3];
        result[result.length - 3] = temp;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}