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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int n = a.length;

    if (n % 2 != 0) {
      return "NO";
    }

    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
    int[] result = new int[n];
    for (int i = 0; i < result.length; ++i) {
      result[i] = sorted[i / 2 + ((i % 2 == 0) ? 0 : (n / 2))];
    }

    if (IntStream.range(0, n)
        .anyMatch(
            i ->
                (long) (result[i] - result[Math.floorMod(i - 1, n)])
                        * (result[i] - result[(i + 1) % n])
                    <= 0)) {
      return "NO";
    }

    return String.format(
        "YES\n%s",
        Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}