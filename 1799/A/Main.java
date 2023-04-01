import java.util.Arrays;
import java.util.HashSet;
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
      int[] p = new int[m];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(n, p));
    }

    sc.close();
  }

  static String solve(int n, int[] p) {
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < p.length; ++i) {
      if (!seen.contains(p[i])) {
        if (seen.size() < result.length) {
          result[result.length - 1 - seen.size()] = i + 1;
        }

        seen.add(p[i]);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
