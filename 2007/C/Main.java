import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c, a, b));
    }

    sc.close();
  }

  static int solve(int[] c, int a, int b) {
    int g = gcd(a, b);

    int[] remainders = Arrays.stream(c).map(ci -> ci % g).sorted().toArray();
    int maxDiff =
        IntStream.range(0, remainders.length)
            .map(i -> Math.floorMod(remainders[(i + 1) % remainders.length] - remainders[i], g))
            .max()
            .getAsInt();

    return (maxDiff == 0) ? 0 : (g - maxDiff);
  }

  static int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
  }
}