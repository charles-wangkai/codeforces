import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      int n = sc.nextInt();
      int[] t = new int[n];
      for (int i = 0; i < t.length; ++i) {
        t[i] = sc.nextInt();
      }

      System.out.println(solve(t));
    }

    sc.close();
  }

  static String solve(int[] t) {
    int n = t.length;

    int k;
    int[] c = new int[n];
    if (Arrays.stream(t).distinct().count() == 1) {
      k = 1;
      Arrays.fill(c, 1);
    } else if (n % 2 == 0 || IntStream.range(0, n).anyMatch(i -> t[i] == t[(i + 1) % n])) {
      k = 2;
      if (n % 2 == 0) {
        for (int i = 0; i < c.length; ++i) {
          c[i] = i % 2 + 1;
        }
      } else {
        int beginIndex =
            IntStream.range(0, n)
                .filter(i -> t[i] == t[Math.floorMod(i - 1, n)])
                .findAny()
                .getAsInt();
        c[beginIndex] = 1;
        for (int i = 1; i < n; ++i) {
          c[(beginIndex + i) % n] =
              (t[(beginIndex + i) % n] == t[(beginIndex + i - 1) % n])
                  ? c[(beginIndex + i - 1) % n]
                  : (3 - c[(beginIndex + i - 1) % n]);
        }
      }
    } else {
      k = 3;
      for (int i = 0; i < c.length - 1; ++i) {
        c[i] = i % 3 + 1;
      }
      c[c.length - 1] =
          IntStream.rangeClosed(1, 3)
              .filter(x -> x != c[0] && x != c[c.length - 2])
              .findAny()
              .getAsInt();
    }

    return String.format(
        "%d\n%s", k, Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}