import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 1_000_000_000;

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
    int[] result = new int[n];
    result[0] = 1;
    for (int i = 1; i < result.length; ++i) {
      long current = result[i - 1] * 3L;
      if (current > LIMIT) {
        return "NO";
      }

      result[i] = (int) current;
    }

    return String.format(
        "YES\n%s",
        Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}