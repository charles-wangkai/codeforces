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

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    int[] pairs = new int[n];
    Arrays.fill(pairs, -1);

    if (k == n - 1) {
      if (n == 4) {
        return "-1";
      }

      pairs[n - 1] = n - 2;
      pairs[n - 2] = n - 1;

      pairs[0] = 1;
      pairs[1] = 0;

      pairs[3] = n - 3;
      pairs[n - 3] = 3;

      pairs[n - 4] = 2;
      pairs[2] = n - 4;
    } else {
      pairs[n - 1] = k;
      pairs[k] = n - 1;

      pairs[0] = n - 1 - k;
      pairs[n - 1 - k] = 0;
    }
    for (int i = 0; i < n; ++i) {
      if (pairs[i] == -1) {
        pairs[i] = n - 1 - i;
        pairs[n - 1 - i] = i;
      }
    }

    return IntStream.range(0, pairs.length)
        .filter(i -> i < pairs[i])
        .mapToObj(i -> String.format("%d %d", i, pairs[i]))
        .collect(Collectors.joining("\n"));
  }
}