import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] s = new int[n];
    int[] f = new int[n];
    int[] t = new int[n];
    for (int i = 0; i < n; ++i) {
      s[i] = sc.nextInt();
      f[i] = sc.nextInt();
      t[i] = sc.nextInt();
    }

    System.out.println(solve(s, f, t, m));

    sc.close();
  }

  static String solve(int[] s, int[] f, int[] t, int m) {
    return IntStream.range(0, s.length)
        .map(
            i -> {
              if (s[i] == f[i]) {
                return t[i];
              }

              int baseTime = t[i] / (2 * (m - 1)) * (2 * (m - 1));
              while (true) {
                int upStartTime = baseTime + (s[i] - 1);
                if (upStartTime >= t[i]) {
                  return (f[i] > s[i])
                      ? (upStartTime + (f[i] - s[i]))
                      : (baseTime + 2 * (m - 1) - (f[i] - 1));
                }

                int downStartTime = baseTime + 2 * (m - 1) - (s[i] - 1);
                if (downStartTime >= t[i]) {
                  return (f[i] < s[i])
                      ? (downStartTime + (s[i] - f[i]))
                      : (baseTime + 2 * (m - 1) + (f[i] - 1));
                }

                baseTime += 2 * (m - 1);
              }
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}