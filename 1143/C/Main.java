import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      p[i] = sc.nextInt();
      if (p[i] != -1) {
        --p[i];
      }

      c[i] = sc.nextInt();
    }

    System.out.println(solve(p, c));

    sc.close();
  }

  static String solve(int[] p, int[] c) {
    int n = p.length;

    boolean[] deleted = new boolean[n];
    Arrays.fill(deleted, true);
    for (int i = 0; i < n; ++i) {
      if (c[i] == 0) {
        deleted[i] = false;

        if (p[i] != -1) {
          deleted[p[i]] = false;
        }
      }
    }

    String result =
        IntStream.range(0, deleted.length)
            .filter(i -> deleted[i])
            .map(i -> i + 1)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

    return result.isEmpty() ? "-1" : result;
  }
}
