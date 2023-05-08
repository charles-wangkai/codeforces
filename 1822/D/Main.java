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
    if (n != 1 && n % 2 == 1) {
      return "-1";
    }

    int[] result = new int[n];
    result[0] = n;
    for (int i = 1; i < result.length; ++i) {
      if (i % 2 == 0) {
        result[i] = i;
      } else {
        result[i] = n - i;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
