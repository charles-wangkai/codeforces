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
      int[] k = new int[n];
      for (int i = 0; i < k.length; ++i) {
        k[i] = sc.nextInt();
      }

      System.out.println(solve(k));
    }

    sc.close();
  }

  static String solve(int[] k) {
    int total = Arrays.stream(k).reduce(Main::lcm).getAsInt();
    int[] result = Arrays.stream(k).map(ki -> total / ki).toArray();

    return (Arrays.stream(result).sum() < total)
        ? Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        : "-1";
  }

  static int lcm(int x, int y) {
    return x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}