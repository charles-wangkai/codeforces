import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(n, k, x));
    }

    sc.close();
  }

  static String solve(int n, int k, int x) {
    int[] taken;
    if (k == 1) {
      taken = null;
    } else if (x == 1) {
      if (n % 2 == 0) {
        taken = IntStream.range(0, n / 2).map(i -> 2).toArray();
      } else if (k == 2) {
        taken = null;
      } else {
        taken = IntStream.range(0, n / 2).map(i -> (i == 0) ? 3 : 2).toArray();
      }
    } else {
      taken = IntStream.range(0, n).map(i -> 1).toArray();
    }

    return (taken == null)
        ? "NO"
        : String.format(
            "YES\n%d\n%s",
            taken.length,
            Arrays.stream(taken).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
