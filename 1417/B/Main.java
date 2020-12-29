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
      int T = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, T));
    }

    sc.close();
  }

  static String solve(int[] a, int T) {
    Set<Integer> zeroSet = new HashSet<>();
    int[] result = new int[a.length];
    for (int i = 0; i < result.length; ++i) {
      if (a[i] * 2 == T) {
        if (zeroSet.contains(a[i])) {
          result[i] = 1;
          zeroSet.remove(a[i]);
        } else {
          result[i] = 0;
          zeroSet.add(a[i]);
        }
      } else if (zeroSet.contains(T - a[i])) {
        result[i] = 1;
      } else {
        result[i] = 0;
        zeroSet.add(a[i]);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
