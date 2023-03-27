import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int[][] a = new int[m][];
      for (int i = 0; i < a.length; ++i) {
        int n = sc.nextInt();
        a[i] = new int[n];
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[][] a) {
    int[] result = new int[a.length];
    Set<Integer> seen = new HashSet<>();
    for (int i = result.length - 1; i >= 0; --i) {
      OptionalInt winner = Arrays.stream(a[i]).filter(x -> !seen.contains(x)).findAny();
      if (winner.isEmpty()) {
        return "-1";
      }

      result[i] = winner.getAsInt();

      for (int aij : a[i]) {
        seen.add(aij);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
