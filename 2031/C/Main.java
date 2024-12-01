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
    if (n % 2 == 1 && n <= 25) {
      return "-1";
    }

    int[] result = new int[n];
    if (n % 2 == 0) {
      for (int i = 0; i < result.length; ++i) {
        result[i] = i / 2 + 1;
      }
    } else {
      int bun = 0;

      ++bun;
      result[0] = bun;
      result[9] = bun;
      result[25] = bun;

      for (int i = 1; i <= 8; i += 2) {
        ++bun;
        result[i] = bun;
        result[i + 1] = bun;
      }

      ++bun;
      result[10] = bun;
      result[26] = bun;

      for (int i = 11; i <= 24; i += 2) {
        ++bun;
        result[i] = bun;
        result[i + 1] = bun;
      }

      for (int i = 27; i < result.length; i += 2) {
        ++bun;
        result[i] = bun;
        result[i + 1] = bun;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}