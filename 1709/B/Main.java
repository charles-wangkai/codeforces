import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] s = new int[m];
    int[] t = new int[m];
    for (int i = 0; i < m; ++i) {
      s[i] = sc.nextInt() - 1;
      t[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(a, s, t));

    sc.close();
  }

  static String solve(int[] a, int[] s, int[] t) {
    long[] leftDamageSums = new long[a.length];
    for (int i = 0; i < leftDamageSums.length; ++i) {
      leftDamageSums[i] = (i == 0) ? 0 : (leftDamageSums[i - 1] + Math.max(0, a[i - 1] - a[i]));
    }

    long[] rightDamageSums = new long[a.length];
    for (int i = rightDamageSums.length - 1; i >= 0; --i) {
      rightDamageSums[i] =
          (i == rightDamageSums.length - 1)
              ? 0
              : (rightDamageSums[i + 1] + Math.max(0, a[i + 1] - a[i]));
    }

    return IntStream.range(0, s.length)
        .mapToLong(
            i ->
                (s[i] < t[i])
                    ? (leftDamageSums[t[i]] - leftDamageSums[s[i]])
                    : (rightDamageSums[t[i]] - rightDamageSums[s[i]]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}