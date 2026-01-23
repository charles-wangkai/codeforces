import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }

    System.out.println(solve(s, m));

    sc.close();
  }

  static String solve(String[] s, int m) {
    int[][] counts = new int[s.length][26];
    for (int i = 0; i < s.length; ++i) {
      for (char c : s[i].toCharArray()) {
        ++counts[i][c - 'A'];
      }
    }

    int[] totals =
        IntStream.range(0, 26).map(p -> Arrays.stream(counts).mapToInt(c -> c[p]).sum()).toArray();

    return IntStream.range(0, s.length)
        .map(
            i -> {
              long[] rests =
                  IntStream.range(0, 26)
                      .mapToLong(p -> (long) (totals[p] - counts[i][p]) * m - counts[i][p])
                      .toArray();
              if (Arrays.stream(rests).anyMatch(rest -> rest < 0)) {
                return -1;
              }

              return IntStream.range(0, 26)
                  .map(
                      p -> {
                        int needed = totals[p] - counts[i][p];

                        return (needed == 0) ? Integer.MAX_VALUE : (int) (rests[p] / needed);
                      })
                  .min()
                  .getAsInt();
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}