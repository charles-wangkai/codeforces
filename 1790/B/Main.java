import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(n, s, r));
    }

    sc.close();
  }

  static String solve(int n, int s, int r) {
    int[] result = new int[n];
    for (int i = 0; i < result.length - 1; ++i) {
      result[i] = r / (n - 1) + ((i < r % (n - 1)) ? 1 : 0);
    }
    result[result.length - 1] = s - r;

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
