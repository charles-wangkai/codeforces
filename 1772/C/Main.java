import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int n = sc.nextInt();

      System.out.println(solve(k, n));
    }

    sc.close();
  }

  static String solve(int k, int n) {
    int[] result = new int[k];
    result[0] = 1;
    int diff = 1;
    for (int i = 1; i < result.length; ++i) {
      if (result[i - 1] + diff + (result.length - 1 - i) <= n) {
        result[i] = result[i - 1] + diff;
        ++diff;
      } else {
        result[i] = n - (result.length - 1 - i);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
