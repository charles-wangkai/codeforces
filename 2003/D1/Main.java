import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][];
      for (int i = 0; i < a.length; ++i) {
        int l = sc.nextInt();
        a[i] = new int[l];
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static long solve(int[][] a, int m) {
    int baseValue =
        Arrays.stream(a)
            .mapToInt(
                ai -> {
                  Set<Integer> values = Arrays.stream(ai).boxed().collect(Collectors.toSet());
                  boolean missingSeen = false;
                  for (int i = 0; ; ++i) {
                    if (!values.contains(i)) {
                      if (missingSeen) {
                        return i;
                      }

                      missingSeen = true;
                    }
                  }
                })
            .max()
            .getAsInt();
    int baseLength = Math.min(m + 1, baseValue + 1);

    return (long) baseValue * baseLength
        + ((baseValue <= m) ? ((baseValue + 1L + m) * (m - baseValue) / 2) : 0);
  }
}