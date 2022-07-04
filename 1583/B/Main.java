import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[m];
      int[] b = new int[m];
      int[] c = new int[m];
      for (int i = 0; i < m; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(n, a, b, c));
    }

    sc.close();
  }

  static String solve(int n, int[] a, int[] b, int[] c) {
    Set<Integer> seen = Arrays.stream(b).boxed().collect(Collectors.toSet());
    int center = IntStream.rangeClosed(1, n).filter(i -> !seen.contains(i)).findAny().getAsInt();

    return IntStream.rangeClosed(1, n)
        .filter(i -> i != center)
        .mapToObj(i -> String.format("%d %d", center, i))
        .collect(Collectors.joining("\n"));
  }
}