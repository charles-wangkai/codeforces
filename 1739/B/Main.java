import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] d = new int[n];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }

      System.out.println(solve(d));
    }

    sc.close();
  }

  static String solve(int[] d) {
    int[] result = new int[d.length];
    result[0] = d[0];
    for (int i = 1; i < result.length; ++i) {
      if (d[i] != 0 && result[i - 1] >= d[i]) {
        return "-1";
      }

      result[i] = result[i - 1] + d[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
